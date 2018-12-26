package edu.njxz.found.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import edu.njxz.found.dao.CategoryDao;
import edu.njxz.found.entity.Category;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
        this.getHibernateTemplate().save(category);
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Category.class, id);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().getCurrentSession();
		String hql="from Category ";
		Query query=session.createQuery(hql);
		List<Category> categoryList=query.list();
		return categoryList;
	}

}
