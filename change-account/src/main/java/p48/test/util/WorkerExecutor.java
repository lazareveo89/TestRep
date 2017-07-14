package p48.test.util;

import org.springframework.beans.factory.annotation.Autowired;

import p48.test.model.Account;
import p48.test.service.AccountService;

public class WorkerExecutor implements Runnable {

    private Account acc;
    
    @Autowired
    private AccountService accService;
    
    public WorkerExecutor(Account acc) {
	this.acc = acc;
    }
    
    @Override
    public void run() {
	getAccService().batchExample(acc);
    }
    
    public AccountService getAccService() {
	return accService;
    }

}
