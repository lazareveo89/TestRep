package com.test.secure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.secure.dao.UserDao;
import com.test.secure.model.User;
import com.test.secure.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	private final static String ERR_MESS = "User not found";
	private final static String ERR_PASS = "Password was wrong";
	private final static String ERR_PASS_LENGTH = "Password must be consist of 8 symbols or more";
	
	@Override
	public User checkUser(User user) {
		User userFromDb = getUserDao().checkUser(user);
		if(userFromDb == null) {
			user.setErrMess(ERR_MESS);
			return user;
		} else if(!user.getPassword().trim().equalsIgnoreCase(userFromDb.getPassword().trim())) {
			user.setErrMess(ERR_PASS);
			return user;
		} else if (user.getPassword().length() < 8) {
			user.setErrMess(ERR_PASS_LENGTH);
			return user;
		} else {
			return userFromDb;
		}
	}

	@Override
	public void addUser(User user) {
		getUserDao().addUser(user);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}	
}