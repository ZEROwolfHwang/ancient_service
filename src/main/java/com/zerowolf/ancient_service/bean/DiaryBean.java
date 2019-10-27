package com.zerowolf.ancient_service.bean;

import java.util.List;

public class DiaryBean {


    private List<ListBean> new_list;
    private List<ListBean> hot_list;

    public List<ListBean> getNew_list() {
        return new_list;
    }

    public void setNew_list(List<ListBean> new_list) {
        this.new_list = new_list;
    }

    public List<ListBean> getHot_list() {
        return hot_list;
    }

    public void setHot_list(List<ListBean> hot_list) {
        this.hot_list = hot_list;
    }


}

