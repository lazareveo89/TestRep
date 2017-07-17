package p48.test.controller;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p48.test.model.Account;
import p48.test.service.AccountService;
import p48.test.util.WorkerExecutor;

@Controller
public class MainController {
    
    @Autowired
    private AccountService accountService;
    
    @RequestMapping(value = "/changeMoneyForAcc", method = RequestMethod.POST, headers = "Accept=application/json")
    public void changeMoneyForAcc(@RequestBody Account acc) {
        getAccountService().changeMoney(acc);
    }
    
    @RequestMapping(value = "/batchUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
    public void batchUpdate(@RequestBody List<Account> accList) {
	ExecutorService executor = Executors.newFixedThreadPool(5);
	    Runnable worker = new WorkerExecutor(accList);
	    executor.execute(worker);
	executor.shutdown();
    }
    
    public AccountService getAccountService() {
	return accountService;
    }
    
}
