package edu.njxz.found.entity.vo;

import java.util.Date;

import edu.njxz.found.entity.User;

public class CommentVo {
	 private Integer commentId;

	 private String commentContent;

	 private User user;  //所属用户

	 private Integer commentMessageid;

	 private String commentDate; //yyyy-MM-dd格式

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
		this.commentContent = commentContent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCommentMessageid() {
		return commentMessageid;
	}

	public void setCommentMessageid(Integer commentMessageid) {
		this.commentMessageid = commentMessageid;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	 
	 
	 

}
