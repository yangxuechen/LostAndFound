package edu.njxz.found.entity;

import java.util.Date;

public class Message {
    private Integer messageId;

    private String messageDescription;

    private String messageUserid;

    private Integer messageCategotyid;

    private Date messageDate;

    private String messagePhoto;

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