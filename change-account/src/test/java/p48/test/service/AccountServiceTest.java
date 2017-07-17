package p48.test.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;


import org.easymock.EasyMockRunner;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import p48.test.controller.MainController;
import p48.test.model.Account;

@RunWith(EasyMockRunner.class)
public class AccountServiceTest {
    
    @TestSubject
    private MainController target = new MainController();
    
    @Test
    public void controllerBehavior_changeMoney() throws Exception {
	
	ApplicationContext context =
    		new ClassPathXmlApplicationContext("spring-config.xml");
	AccountService accService = (AccountService) context.getBean("accountService");
	
	try {
	Account acc = new Account();
	acc.setId(Integer.valueOf(4));
	acc.setMoney(BigDecimal.valueOf(100));
	
	accService.changeMoney(acc);
	} catch(Exception e) {
	    fail();
	}
	
    }    
}
