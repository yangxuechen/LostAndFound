package edu.njxz.found.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.njxz.found.entity.Message;
import edu.njxz.found.entity.User;
import edu.njxz.found.entity.vo.CommentVo;
import edu.njxz.found.entity.vo.Post;
import edu.njxz.found.service.CommentService;
import edu.njxz.found.service.MessageService;

@Controller
@Scope("prototype")
public class MessageAction extends ActionSupport{
	
	private String category;
	private String content;
	private File upload;
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private CommentService commentService;
	/**
	 * 用户发布信息
	 * 
	 * 不用这个方法了
	 * @return
	 */
	public String userSendMessage() {
		
		String path=messageService.savePhoto(upload);
		User user=(User) ActionContext.getContext().getSession().get("user");
		Message message=new Message();
		message.setMessageUserid(user.getUserId()+"");
		message.setMessagePhoto(path);
		message.setMessageCategotyid(1);
		message.setMessageDescription(content);
		message.setMessageDate(new Date());
		messageService.saveMessage(message);
		return "success";
	}
	
	/**
	 * 用户发布信息
	 * @return
	 */
	public String send() {
		String path=messageService.savePhoto(upload);
		User user=(User) ActionContext.getContext().getSession().get("user");
		Message message=new Message();
		message.setMessageUserid(user.getUserId()+"");
		message.setMessagePhoto("images/"+path);
		message.setMessageCategotyid(1);
		message.setMessageDescription(content);
		message.setMessageDate(new Date());
		messageService.saveMessage(message);
		return "success";
	}
	
	/**
	 * 跳转到评论页面
	 * @return
	 */
	public String toCommentPage() {
		//获取Context对象
		ActionContext context=ActionContext.getContext();

	    String 	messageId=ServletActionContext.getRequest().getParameter("messageId");
	    System.out.println(messageId);
		List<CommentVo> commentList=commentService.findAll(Integer.parseInt(messageId));
		for(CommentVo c:commentList) {
			System.out.println(c.getUser().getUserName()+" "+c.getCommentContent()+" "+c.getCommentDate());
		}
		
		context.put("commentList", commentList);
		
		context.put("messageId", messageId);
		return "yes";
	}
	
	/**
	 * 跳转到我的发布页面
	 * @return
	 */
	public String toMySend() {
		//获取Context对象
		ActionContext context=ActionContext.getContext();
		User user=(User) context.getSession().get("user");
		List<Post> postList=messageService.findAllPostByUserId(user.getUserId());
		context.put("postList", postList);
		return "ok";
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	

}
