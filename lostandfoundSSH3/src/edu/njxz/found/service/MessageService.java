package edu.njxz.found.service;

import java.io.File;
import java.util.List;

import edu.njxz.found.entity.Message;
import edu.njxz.found.entity.vo.Post;

public interface MessageService {
	
	//插入一条记录
	void saveMessage(Message message);
	//更新一条记录
	void updateMessage(Message message);
	//通过用户id查询messageList
	List<Message> findByUserId(int userId);
	//查找所有MessageList
	List<Message> findAll();
	
	//查询所有PostList -->Message的封装对象
	List<Post> findAllPost(); 
	/**
	 * 
	 * 查询当前用户的所有postList
	 * @param id
	 * @return
	 */
	List<Post> findAllPostByUserId(int id);
	
	/**
	 * 保存上传的图片
	 * @param upload
	 * @return  图片路径
	 */
	String savePhoto(File upload);
	


}
