//package com.zerowolf.ancient_service.bean;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.List;
//
//public class DiaryUtil {
//
//    // 获取最新的日记的List (目前从Assets/userInfo.json中默认获得)
//    public static List<DiaryBean.ListBean> getNewestList(Context context) {
//        //以下是获取本地json文件的方式 , 并写入DiaryBean类,方便使用的地方调用
//        String fileName = "userInfo.json";
//        String userJson = JsonUtils.getJson(context, fileName);
//
//        Gson gson = new Gson();
//        DiaryBean diaryBean = gson.fromJson(userJson, DiaryBean.class);
//        return diaryBean.getNew_list();
//    }
//
//    public static String getJson(Context context, String fileName) {
//        StringBuilder stringBuilder = new StringBuilder();
//        //获得assets资源管理器
//        AssetManager assetManager = context.getAssets();
//        //使用IO流读取json文件内容
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
//                    assetManager.open(fileName), "utf-8"));
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return stringBuilder.toString();
//    }
//}
