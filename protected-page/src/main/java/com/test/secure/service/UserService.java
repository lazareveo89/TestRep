package com.test.secure.service;

import com.test.secure.model.User;

public interface UserService {
	public User checkUser(User user);
	public void addUser(User user);
}
