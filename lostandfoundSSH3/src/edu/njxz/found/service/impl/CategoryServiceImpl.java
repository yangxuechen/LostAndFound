package edu.njxz.found.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.njxz.found.dao.CategoryDao;
import edu.njxz.found.entity.Category;
import edu.njxz.found.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
        categoryDao.saveCategory(category);
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

}
