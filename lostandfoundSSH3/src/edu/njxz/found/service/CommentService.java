package edu.njxz.found.service;

import java.util.List;

import edu.njxz.found.entity.Comment;
import edu.njxz.found.entity.vo.CommentVo;

public interface CommentService {
	    //插入一条记录
		void saveComment(Comment comment);
		
		//查询一条记录的所有评论
		List<Comment> findAllByMessageId(int id);
		
		//查询一条记录的所有评论 封装后的数据
		List<CommentVo> findAll(int id);

}
