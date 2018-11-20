package edu.njxz.lostandfound.entity;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private String commentContent;

    private String commentUserid;

    private Integer commentMessageid;

    private Date commentDate;

    private Integer commentSubmitCount;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCommentUserid() {
        return commentUserid;
    }

    public void setCommentUserid(String commentUserid) {
        this.commentUserid = commentUserid == null ? null : commentUserid.trim();
    }

    public Integer getCommentMessageid() {
        return commentMessageid;
    }

    public void setCommentMessageid(Integer commentMessageid) {
        this.commentMessageid = commentMessageid;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getCommentSubmitCount() {
        return commentSubmitCount;
    }

    public void setCommentSubmitCount(Integer commentSubmitCount) {
        this.commentSubmitCount = commentSubmitCount;
    }
}