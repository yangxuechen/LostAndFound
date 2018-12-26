package edu.njxz.found.dao;

import java.util.List;

import edu.njxz.found.entity.Comment;

public interface CommentDao {
	
	//插入一条记录
	void saveComment(Comment comment);
	
	//查询一条记录的所有评论
	List<Comment> findAllByMessageId(int id);

}
