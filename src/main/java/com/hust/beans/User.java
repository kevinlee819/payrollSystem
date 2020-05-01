package com.hust.beans;

/**
 * @author lkj
 * @date 2019/6/28
 * @time 16:12
 **/
public class User {
    private String userName;
    private String password;
    public User(){}

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
