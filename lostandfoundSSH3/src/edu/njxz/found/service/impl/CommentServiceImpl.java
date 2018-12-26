package edu.njxz.found.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.njxz.found.dao.CommentDao;
import edu.njxz.found.dao.UserDao;
import edu.njxz.found.entity.Comment;
import edu.njxz.found.entity.User;
import edu.njxz.found.entity.vo.CommentVo;
import edu.njxz.found.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	@Autowired
	private UserDao userDao;
	@Override
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
        commentDao.saveComment(comment);
	}

	@Override
	public List<Comment> findAllByMessageId(int id) {
		// TODO Auto-generated method stub
		return commentDao.findAllByMessageId(id);
	}

	@Override
	public List<CommentVo> findAll(int id) {
		// TODO Auto-generated method stub
		List<Comment> commentList=findAllByMessageId(id);
		List<CommentVo> commentVoList=new ArrayList<CommentVo>();
		for(Comment c:commentList) {
			User user=userDao.findUserById(Integer.parseInt(c.getCommentUserid()));
			CommentVo commentVo=new CommentVo();
			commentVo.setUser(user);
			commentVo.setCommentId(c.getCommentId());
			commentVo.setCommentContent(c.getCommentContent());
			commentVo.setCommentMessageid(c.getCommentMessageid());
			  //将时间转化成yyyy-MM-dd格式的字符串
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        String str=sdf.format(c.getCommentDate());
	        commentVo.setCommentDate(str);
	        
	        commentVoList.add(commentVo);
		}
		return commentVoList;

	}

}
