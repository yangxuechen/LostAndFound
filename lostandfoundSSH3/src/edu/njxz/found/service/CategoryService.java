package edu.njxz.found.service;

import java.util.List;

import edu.njxz.found.entity.Category;

public interface CategoryService {
	
	//插入一条记录
		void saveCategory(Category category);
		
		//通过id查询一条记录
		Category findById(int id);
	 
		//查询所有记录
		List<Category> findAll();

}
