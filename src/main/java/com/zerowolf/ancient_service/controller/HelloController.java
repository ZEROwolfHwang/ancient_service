package com.zerowolf.ancient_service.controller;


import com.alibaba.fastjson.JSONObject;
import com.zerowolf.ancient_service.bean.ListBean;
import com.zerowolf.ancient_service.utils.PathUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Controller
@EnableAutoConfiguration
@ResponseBody
public class HelloController {
    @Value("classpath:static/json/userInfo.json")
    private Resource areaRes;

    @RequestMapping("/hello")
    private String index() {
        return "Hello World!";
    }

    @RequestMapping("/addNew")
    private String addNew(ListBean listBean) {
//        return "Hello World!";
//        ListBean listBean = new ListBean();
//        listBean.setContent("内容");
//        listBean.setLoveCount(198);
//        listBean.setImageUrl("icon_user_01");
//        listBean.setPublishTime("2019-08-24");
//        listBean.setUsername("独行者bbb");

        PathUtil.updateJson(listBean);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("msg", "成功");

        return jsonObject.toJSONString();
    }

    @RequestMapping("/getJson")
    private String getJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("msg", "成功");
        jsonObject.put("data", PathUtil.getJsonData().toJSONString());

        return jsonObject.toJSONString();
    }

    @RequestMapping("/reset")
    private String resetJson() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
//            jsonStr = new String(IOUtils.readFully(areaRes.getInputStream(), -1,true));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(areaRes.getInputStream()));
            String jsonStr = null;
            while ((jsonStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(jsonStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PathUtil.resetJson(stringBuilder.toString());
//        return ;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("msg", "成功");

        return jsonObject.toJSONString();
    }
}
