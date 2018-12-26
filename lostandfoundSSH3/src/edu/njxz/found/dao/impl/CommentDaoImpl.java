package edu.njxz.found.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import edu.njxz.found.dao.CommentDao;
import edu.njxz.found.entity.Comment;

public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {

	@Override
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
        this.getHibernateTemplate().save(comment);
	}

	@Override
	public List<Comment> findAllByMessageId(int id) {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().getCurrentSession();
		String hql="from Comment where commentMessageid=:id";
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		List<Comment> commentList=query.list();
		return commentList;
	}

}
