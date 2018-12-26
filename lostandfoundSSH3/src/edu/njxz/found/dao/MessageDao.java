package edu.njxz.found.dao;

import java.util.List;

import edu.njxz.found.entity.Message;
import edu.njxz.found.utils.page.Page;

public interface MessageDao {
	
	//插入一条记录
	void insert(Message message);
	
	//更新一条记录
	void updateMessage(Message message);
	
	//通过用户id查询messageList
	List<Message> findByUserId(int userId);
	
	//查找所有MessageList
	List<Message> findAll();
	/**
	 * 分页查询
	 * @param pageNum  页码
	 * @param size    每页数量
	 * @return
	 */
	Page<Message> findByPageNum(int pageNum,int size);
	
	/**
	 * 分页查询
	 * @param userId   用户Id
	 * @param pageNum   页码
	 * @param size     每页数量
	 * @return
	 */
	Page<Message> findByPageNumAndUserId(int userId,int pageNum,int size);

}
