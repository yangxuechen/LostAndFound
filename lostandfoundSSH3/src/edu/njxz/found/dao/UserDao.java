package edu.njxz.found.dao;

import java.util.List;

import edu.njxz.found.entity.User;

public interface UserDao {
	
	//插入一个用户
    void saveUser(User user);
    //通过id删除一个用户
    void deleteUserById(int id);
    //更新用户信息
    void updateUser(User user);
    //通过name查询用户
    List<User> findUserByName(String userName);
    //通过id查询用户
    User findUserById(int id);
    
}
