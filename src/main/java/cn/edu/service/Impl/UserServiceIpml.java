package cn.edu.service.Impl;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.edu.bean.User;
import cn.edu.service.*;
import cn.edu.dao.*;
@Service("userService")  
public class UserServiceIpml implements UserService{
	@Resource    
    private UserDao userDao;
	
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}
	
	
	public User getUserByPrimaryKey(String userId) {
		// TODO Auto-generated method stub
		
		return userDao.getUserByPrimaryKey(userId);
	}
	
	public void deleteByPrimaryKey(String userId) {
		// TODO Auto-generated method stub
		userDao.deleteByPrimaryKey(userId);
	}

	
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}


	@Override
	public List<User> getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserName(userName);
	}


	


	
	

}
