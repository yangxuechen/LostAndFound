package edu.njxz.found.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.njxz.found.entity.Category;
import edu.njxz.found.service.CategoryService;
import edu.njxz.found.service.UserService;

public class CategoryTest {
	
	ApplicationContext ac;   //读取Spring配置文件，返回上下文对象
    CategoryService categoryService; //用于接收一个UserServiceImpl实例
    @Before
    public void setUp(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        categoryService=(CategoryService) ac.getBean("categoryService");
    }
    
	@Test
	public void saveTest() {
		Category c=new Category();
		c.setCategoryName("服饰");
		categoryService.saveCategory(c);
	}
	
	@Test
	public void selectTest() {
		Category c=categoryService.findById(1);
		System.out.println(c.getCategoryName());
	}
	
	@Test
	public void testFindAll() {
		List<Category> cList=categoryService.findAll();
		for(Category c:cList) {
			System.out.println(c.getCategoryName());
		}
	}

}
