package edu.njxz.lostandfound.entity;

import java.util.Date;

public class Message {
    private Integer messageId;  //失物招领id

    private String messageDescription; //失物招领内容描述

    private String messageUserid;  //发布者id

    private Integer messageCategotyid;  //类别id

    private Date messageDate;   //发布日期

    private String messagePhoto; //图片路径

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription == null ? null : messageDescription.trim();
    }

    public String getMessageUserid() {
        return messageUserid;
    }

    public void setMessageUserid(String messageUserid) {
        this.messageUserid = messageUserid == null ? null : messageUserid.trim();
    }

    public Integer getMessageCategotyid() {
        return messageCategotyid;
    }

    public void setMessageCategotyid(Integer messageCategotyid) {
        this.messageCategotyid = messageCategotyid;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessagePhoto() {
        return messagePhoto;
    }

    public void setMessagePhoto(String messagePhoto) {
        this.messagePhoto = messagePhoto == null ? null : messagePhoto.trim();
    }
}