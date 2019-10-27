package com.zerowolf.ancient_service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadTxtFile {

    public static String readTxtFile(String filePath) {
        String txtStr = "";//存储文件内容
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                StringBuffer bf = new StringBuffer();
                //逐行读取文件内容
                while ((line = br.readLine()) != null) {
                    bf.append(line);
                }
                txtStr = bf.toString();
                isr.close();
            } else {
                System.out.println("没有找到该文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return txtStr;
    }
}
