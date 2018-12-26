package edu.njxz.found.entity;

public class User {

    private int userId;  //用户id
    private String userName;//用户名
    private String userPassword;//密码
    private String userEmail;  //邮箱
    private String userPhoto;   //头像地址
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserPhoto() {
        return userPhoto;
    }
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

}
