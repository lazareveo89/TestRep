package p48.test.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import p48.test.model.Account;
import p48.test.service.AccountService;

public class WorkerExecutor implements Runnable {

    private List<Account> acc;
    
    @Autowired
    private AccountService accService;
    
    public WorkerExecutor(List<Account> acc) {
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
