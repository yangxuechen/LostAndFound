package edu.njxz.found.service.impl;

import edu.njxz.found.dao.UserDao;
import edu.njxz.found.entity.User;
import edu.njxz.found.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
	@Override
	public void deleteUserByUserId(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUserById(id);
		
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}
	@Override
	public User userLogin(String userName, String password) {
		// TODO Auto-generated method stub
		List<User> userList=userDao.findUserByName(userName);
		for(User user:userList) {
			System.out.println(user.getUserId()+" "+user.getUserName());
			if(user.getUserPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}
	@Override
	public void userSelectById(int id) {
		// TODO Auto-generated method stub
		User user=userDao.findUserById(id);
		System.out.println(user.getUserName());
	}
}
