package com.zerowolf.ancient_service.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zerowolf.ancient_service.ReadTxtFile;
import com.zerowolf.ancient_service.bean.ListBean;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.filechooser.FileSystemView;

public class PathUtil {
    private static boolean isDev = false;

    public static String getJsonPath() {
        FileSystemView fsv = FileSystemView.getFileSystemView();

        File com = fsv.getHomeDirectory();//获取桌面路径
        String filePath;
        if (isDev) {
            filePath = com.getPath() + "/Desktop/diaryJson.json";//指定要读取文件read.txt的路径（桌面）
        } else {
            filePath = com.getPath() + "/zerowolf/diaryJson.json";//指定要读取文件read.txt的路径（桌面）
        }
        return filePath;
    }

    public static JSONObject getJsonData() {
        String jsonPath = PathUtil.getJsonPath();
        System.out.println(jsonPath);

        String str = ReadTxtFile.readTxtFile(jsonPath);//读取read.txt文件输出字符串

        System.out.println(str);

        JSONObject jsonObject = JSONObject.parseObject(str);
        return jsonObject;
    }

    public static void updateJson(ListBean diaryBean) {
        JSONObject jsonObject = getJsonData();
        JSONArray newList = jsonObject.getJSONArray("new_list");

        newList.add(diaryBean);
        reWriteJson(JSONObject.toJSONString(jsonObject));
    }

    public static void resetJson(String resetString) {
        reWriteJson(resetString);
    }

    private static void reWriteJson(String resetString) {
        File f = new File(PathUtil.getJsonPath());//创建保存文件save.txt（桌面）
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.print(resetString);//将字符串写入到save.txt
        pw.close();
    }

    private static File getResFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) { // 如果同级目录没有，则去config下面找
            file = new File("config/" + filename);
        }
        Resource resource = new FileSystemResource(file);
        if (!resource.exists()) { //config目录下还是找不到，那就直接用classpath下的
            file = ResourceUtils.getFile("classpath:" + filename);
        }
        return file;
    }
}
