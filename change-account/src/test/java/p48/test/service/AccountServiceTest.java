package p48.test.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.TestSubject;
import org.junit.Ignore;
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

    private static ApplicationContext context = new ClassPathXmlApplicationContext(
	    "spring-config.xml");

    @Ignore
    @Test
    public void controllerBehavior_changeMoney() throws Exception {
	AccountService accService = (AccountService) context
		.getBean("accountService");

	try {
	    Account acc = new Account();
	    acc.setId(Integer.valueOf(4));
	    acc.setMoney(BigDecimal.valueOf(100));

	    accService.changeMoney(acc);
	} catch (Exception e) {
	    fail();
	}

    }

    @Test
    public void controllerBehavior_batchExample() throws Exception {
	AccountService accService = (AccountService) context
		.getBean("accountService");
	for (int j = 1; j < 1000; j++) {
	    List<Account> list = new ArrayList();
	    try {
		for (int i = 1; i < 1000; i++) {
		    Account acc = new Account();
		    acc.setMoney(BigDecimal.valueOf(111));
		    list.add(acc);
		}
		accService.batchExample(list);
	    } catch (Exception e) {
		fail();
	    }
	}
    }
}