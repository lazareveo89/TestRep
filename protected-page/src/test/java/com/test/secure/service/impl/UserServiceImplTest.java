package com.test.secure.service.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.test.secure.dao.UserDao;
import com.test.secure.model.User;

@RunWith(EasyMockRunner.class)
public class UserServiceImplTest {
    
    @Mock
    private UserDao userDao;
    
    @TestSubject
    private UserServiceImpl userService = new UserServiceImpl();
    
    @After
    public void tearDown() throws Exception {
		reset(userDao);
    }
    
    @Test
    public void test_execute_A$DelegateExecution() throws Exception {
	User user = new User();
	user.setLogin("ttt");
	expect(userDao.checkUser(anyObject(User.class))).andReturn(user);
	
	replay(userDao);
	try{
	userService.checkUser(user);
	verify(userDao);
	} catch(Exception e) {
	    fail();
	}
	
    }
    
    @Test
    public void test_execute_B$DelegateExecution() throws Exception {
	User user = new User();
	user.setLogin("ttt");
	userDao.addUser(user);
	
	replay(userDao);
	try {
	userService.addUser(user);
	verify(userDao);
	} catch(Exception e) {
	    fail();
	}
	
    }
}