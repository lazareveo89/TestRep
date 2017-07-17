package com.test.searchplace.service;

import java.util.List;

import com.test.searchplace.model.User;

public interface UserService {
	void createUser(User user);
	List<User> getUserInfo(String login);
	void updateUserInfo(User user);
	void deleteUserInfo(User user);
}
