package com.test.searchplace.dao;

import java.util.List;

import com.test.searchplace.model.User;

public interface UserDao {
	void createUser(User user);
	List<User> getUserInfo(String login);
	void updateUserInfo(User user);
	void deleteUserInfo(User user);
}