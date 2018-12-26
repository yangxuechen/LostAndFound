package edu.njxz.found.entity.vo;

import java.util.Date;

import edu.njxz.found.entity.Category;
import edu.njxz.found.entity.User;

/**
 * 视图层对象 失物招领信息
 * @author yangxuechen
 *
 */
public class Post {
	    private Integer messageId;  //id

	    private String messageDescription;  //描述
        
	    private User user;   //所属用户

	    private Category category;  //种类

	    private String messageDate;   //日期 yyyy-MM-dd格式

	    private String messagePhoto;  //图片路径

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
			this.messageDescription = messageDescription;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public String getMessageDate() {
			return messageDate;
		}

		public void setMessageDate(String messageDate) {
			this.messageDate = messageDate;
		}

		public String getMessagePhoto() {
			return messagePhoto;
		}

		public void setMessagePhoto(String messagePhoto) {
			this.messagePhoto = messagePhoto;
		}
	    
	    

}
