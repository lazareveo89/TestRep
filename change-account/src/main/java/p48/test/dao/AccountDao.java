package p48.test.dao;

import java.util.List;

import p48.test.model.Account;

public interface AccountDao {
    public void changeAccountsMoney(Account account);
    void batchExample(List<Account> acc);
    Account getAccById(Integer id);
}
