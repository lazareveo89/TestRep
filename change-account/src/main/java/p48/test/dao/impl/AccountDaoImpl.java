package p48.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import p48.test.dao.AccountDao;
import p48.test.model.Account;

public class AccountDaoImpl implements AccountDao {

    private DataSource dataSource;

    @Override
    public Account getAccById(Integer id) {
	Connection conn = null;
	Account acc = new Account();
	try {
	    conn = dataSource.getConnection();
	    PreparedStatement pr = conn
		    .prepareStatement("select id, money from account where id=?");
	    pr.setInt(1, id);

	    ResultSet rs = pr.executeQuery();
	    if (rs.next()) {
		acc.setId(rs.getInt("id"));
		acc.setMoney(rs.getBigDecimal("money"));
	    }
	    rs.close();
	    pr.close();
	} catch (SQLException e) {
	   
	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (SQLException e) {

		}
	    }
	}
	return acc;
    }

    @Override
    public void batchExample(List<Account> accList) {
	Connection conn = null;
	try {
	    conn = dataSource.getConnection();
	    conn.setAutoCommit(false);
	    PreparedStatement pr = conn
		    .prepareStatement("insert into account (money) values (?)");
	    for(Account acc : accList) {
		pr.setBigDecimal(1, acc.getMoney());
		pr.addBatch();
	    }
	    int[] updRows = pr.executeBatch();
	    conn.commit();
	} catch(SQLException e) {
	    
	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (SQLException e) {

		}
	    }
	}
    }

    public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
    }

    @Override
    public void changeAccountsMoney(Account account) {
	Connection conn = null;
	try {
	    conn = dataSource.getConnection();
	    PreparedStatement pr = conn
		    .prepareStatement("update account set money=? where id=?");
	    pr.setBigDecimal(1, account.getMoney());
	    pr.setInt(2, account.getId().intValue());
	    pr.executeUpdate();
	    pr.close();
	} catch (SQLException e) {

	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (SQLException e) {

		}
	    }
	}
    }
}
