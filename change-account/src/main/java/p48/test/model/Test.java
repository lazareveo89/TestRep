package p48.test.model;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import p48.test.dao.AccountDao;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Account accN = new Account();
	accN.setId(4);
	accN.setMoney(BigDecimal.valueOf(4).setScale(2));
	ApplicationContext context =
    		new ClassPathXmlApplicationContext("spring-config.xml");
	AccountDao accdao = (AccountDao) context.getBean("accountDao");
	accdao.changeAccountsMoney(accN);
    }

}
