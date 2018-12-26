package edu.njxz.found.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import edu.njxz.found.dao.MessageDao;
import edu.njxz.found.entity.Message;
import edu.njxz.found.utils.page.Page;

public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {

	@Override
	public void insert(Message message) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(message);
	}

	@Override
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(message);
	}

	@Override
	public List<Message> findByUserId(int userId) {
		// TODO Auto-generated method stub
		Session session =this.getSessionFactory().getCurrentSession();
		String hql="from Message where messageUserid=:id";
		Query query=session.createQuery(hql);
		query.setParameter("id", new Integer(userId).toString());
		List<Message> messageList=query.list();
		return messageList;
	}

	@Override
	public List<Message> findAll() {
		Session session =this.getSessionFactory().getCurrentSession();
		String hql="from Message ";
		Query query=session.createQuery(hql);
		List<Message> messageList=query.list();
		return messageList;
	}

	@Override
	public Page<Message> findByPageNum(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Message> findByPageNumAndUserId(int userId, int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
