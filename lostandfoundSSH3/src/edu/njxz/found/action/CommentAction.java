package edu.njxz.found.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.njxz.found.entity.Comment;
import edu.njxz.found.entity.User;
import edu.njxz.found.entity.vo.CommentVo;
import edu.njxz.found.service.CommentService;

@Controller
@Scope("prototype")
public class CommentAction extends ActionSupport{
	
	private String content;
	private String messageId;
	
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Autowired
	private CommentService commentService;
	
	public String comment() {
	//	System.out.println(content+" ////"+messageId);
		ActionContext actionContext=ActionContext.getContext();
		User user=(User) actionContext.getSession().get("user");
		Comment comment=new Comment();
		comment.setCommentUserid(user.getUserId()+"");
		comment.setCommentContent(content);
		comment.setCommentDate(new Date());
		comment.setCommentMessageid(Integer.parseInt(messageId));
		
		commentService.saveComment(comment);
		
		//查询数据，跳转到评论页面
		List<CommentVo> commentList=commentService.findAll(Integer.parseInt(messageId));
		for(CommentVo c:commentList) {
			System.out.println(c.getUser().getUserName()+" "+c.getCommentContent()+" "+c.getCommentDate());
		}
		
		actionContext.put("commentList", commentList);
		
		actionContext.put("messageId", messageId);
		return "yes";
	}

}
