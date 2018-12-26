package edu.njxz.found.service;

import edu.njxz.found.entity.User;

public interface UserService {
	/**
	 * 保存用户 用户注册
	 * @param user
	 */
    void saveUser(User user);
    
    /**
     * 删除用户
     * @param id
     */
    void deleteUserByUserId(int id);
    
    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);
    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    User userLogin(String userName,String password);
    
    /**
     * 通过id查询用户
     * @param id
     */
    void userSelectById(int id);
    
}
