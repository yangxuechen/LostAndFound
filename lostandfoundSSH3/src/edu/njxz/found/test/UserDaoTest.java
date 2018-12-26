package edu.njxz.found.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.njxz.found.dao.MessageDao;
import edu.njxz.found.dao.UserDao;
import edu.njxz.found.entity.User;
import edu.njxz.found.service.UserService;

public class UserDaoTest {
	 ApplicationContext ac;   //读取Spring配置文件，返回上下文对象
	    UserService userService; //用于接收一个UserServiceImpl实例
	    @Before
	    public void setUp(){
	        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	        userService=(UserService) ac.getBean("userService");
	    }
	    
        @Test
	    public void insertUserTest() {
	    	User user=new User();
	    	user.setUserName("James");
	    	user.setUserPassword("123456");
	    	
	    	userService.saveUser(user);
	    }
        
        @Test
        public void deleteUserTest() {
        	userService.deleteUserByUserId(1);
        }
        
        @Test
        public void updateUserTest() {
        	User user=new User();
        	user.setUserId(2);
        	user.setUserPassword("111");
        	user.setUserName("love");
        	user.setUserEmail("nnnn");
        	userService.updateUser(user);
        }
        
        @Test
        public void findUserByIdTest() {
        	User b=userService.userLogin("love", "111");
        	if(b!=null) {
        		System.out.println("success"+b.getUserName()+" "+b.getUserId());
        	}else {
        		System.out.println("fail");
        	}
        }
        
        @Test
        public void findUserbyidTest() {
        	userService.userSelectById(2);
        }
}
