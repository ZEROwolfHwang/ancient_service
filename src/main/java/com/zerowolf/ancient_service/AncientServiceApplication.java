package com.zerowolf.ancient_service;

import com.zerowolf.ancient_service.bean.ListBean;
import com.zerowolf.ancient_service.utils.PathUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AncientServiceApplication {

    public static void main(String[] args) {
//        saveFile();

        SpringApplication.run(AncientServiceApplication.class, args);
    }

    public static void saveFile() {

        ListBean listBean = new ListBean();
        listBean.setContent("内容");
        listBean.setLoveCount(198);
        listBean.setImageUrl("icon_user_01");
        listBean.setPublishTime("2019-08-24");
        listBean.setUsername("独行者bbb");

        PathUtil.updateJson(listBean);
    }

}
