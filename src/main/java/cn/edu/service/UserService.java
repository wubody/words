package cn.edu.service;

import java.util.List;

import cn.edu.bean.User;

public interface UserService {
	//插入用户
    public void insertUser(User user); 
    //通过主键获取用户
    public User getUserByPrimaryKey(String userId); 
    //通过主键删除用户
    public void deleteByPrimaryKey(String userId);
    //跟新用户数据
    public void updateUser(User user);    
    //获取所有用户
    public List<User> getAllUser();   
    //通过用户姓名获取用户
    public List<User> getUserByUserName(String userName);
}
