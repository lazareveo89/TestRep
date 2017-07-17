package p48.test.service.impl;

import java.math.BigDecimal;
import java.util.List;

import p48.test.dao.AccountDao;
import p48.test.model.Account;
import p48.test.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    
    @Override
    public void changeMoney(Account account) {
	Account acc = accountDao.getAccById(account.getId());
	if(acc != null && acc.getMoney() != null && account.getMoney().compareTo(BigDecimal.ZERO) >=0) {
	    if(account.getMoney().compareTo(acc.getMoney()) < 0) {
	    BigDecimal diff = acc.getMoney().subtract(account.getMoney());
	    if(diff.compareTo(BigDecimal.ZERO) >= 0) {
		accountDao.changeAccountsMoney(account);
	    }
	    } else {
		accountDao.changeAccountsMoney(account);
	    }
	}
    }

    @Override
    public void batchExample(List<Account> acc) {
	accountDao.batchExample(acc);	
    }
    
    public void setAccountDao(AccountDao accountDao) {
	this.accountDao = accountDao;
    }
}
