package p48.test.service;


import java.util.List;

import p48.test.model.Account;

public interface AccountService {
    void changeMoney(Account acc);
    void batchExample(List<Account> acc);
}