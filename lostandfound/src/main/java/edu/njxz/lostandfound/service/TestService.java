package edu.njxz.lostandfound.service;

import java.util.List;

import edu.njxz.lostandfound.entity.Comment;
import edu.njxz.lostandfound.entity.Message;

public interface TestService {
	
	public List<Message> showAllMessage();
	public List<Comment> showAllCommentByMessageId(int messageId);

}
