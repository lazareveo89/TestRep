package p48.test.dao;

import p48.test.model.Account;

public interface AccountDao {
    public void changeAccountsMoney(Account account);
    void batchExample(Account acc);
    Account getAccById(Integer id);
}
