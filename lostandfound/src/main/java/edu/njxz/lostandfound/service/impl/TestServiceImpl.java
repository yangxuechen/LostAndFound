package edu.njxz.lostandfound.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.njxz.lostandfound.entity.Comment;
import edu.njxz.lostandfound.entity.Message;
import edu.njxz.lostandfound.mapper.CategoryMapper;
import edu.njxz.lostandfound.mapper.CommentMapper;
import edu.njxz.lostandfound.mapper.MessageMapper;
import edu.njxz.lostandfound.mapper.UserMapper;
import edu.njxz.lostandfound.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private CommentMapper comm;
	
	@Autowired
	private MessageMapper mesm;
	
	@Autowired
	private CategoryMapper catm;
	
	@Autowired
	private UserMapper usem;

	@Override
	public List<Message> showAllMessage() {
		return mesm.showAllMessage();
	}

	@Override
	public List<Comment> showAllCommentByMessageId(int messageId) {
		return comm.showAllCommentByMessageId(messageId);
	}
	
	

}
