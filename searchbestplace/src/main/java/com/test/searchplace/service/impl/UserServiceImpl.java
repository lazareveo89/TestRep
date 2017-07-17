package com.test.searchplace.service.impl;

import com.test.searchplace.dao.UserDao;
import com.test.searchplace.model.User;
import com.test.searchplace.service.List;
import com.test.searchplace.service.String;
import com.test.searchplace.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    
    @Override
    public void createUser(User user) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public List getUserInfo(String login) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void updateUserInfo(User user) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void deleteUserInfo(User user) {
	// TODO Auto-generated method stub
	
    }
    
    public UserDao getUserDao() {
	return userDao;
    }

}
