package com.zerowolf.ancient_service.bean;

public class ListBean {
    /**
     * username : ZEROwolf
     * publishTime : 2019.02.11
     * imageUrl : icon_user_01
     * content : kjbasjdaksdlls.dasjdasldajsdlkasl;d;lasdljas
     */

    private String username;
    private String publishTime;
    private String imageUrl;
    private String content;
    private String title;
    private String uuid;
    private int loveCount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(int loveCount) {
        this.loveCount = loveCount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
