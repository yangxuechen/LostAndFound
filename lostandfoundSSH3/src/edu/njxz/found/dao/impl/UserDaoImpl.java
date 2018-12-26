package edu.njxz.found.dao.impl;

import edu.njxz.found.dao.UserDao;
import edu.njxz.found.entity.Message;
import edu.njxz.found.entity.User;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    public void saveUser(User user) {
        this.getHibernateTemplate().save(user);
    }

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUserId(id);
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}

	@Override
	public List<User> findUserByName(String userName) {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().getCurrentSession();
		String hql="from User where userName=:n";
		Query query=session.createQuery(hql);
		query.setParameter("n", userName);
		List<User> userList=query.list();
		return userList;
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(User.class, id);
		
//		Session session =this.getSessionFactory().getCurrentSession();
//		String hql="from User where userId=:id";
//		Query query=session.createQuery(hql);
//		query.setParameter("id", id);
//	    User user=(User) query.uniqueResult();
//	    return user;
	}
}
