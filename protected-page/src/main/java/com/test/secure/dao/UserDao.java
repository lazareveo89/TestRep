package com.test.secure.dao;

import com.test.secure.model.User;

public interface UserDao {
	public User checkUser(User user);
	public void addUser(User user);
}