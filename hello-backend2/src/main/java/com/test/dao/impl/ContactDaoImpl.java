package com.test.dao.impl;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.test.dao.ContactDao;

public class ContactDaoImpl implements ContactDao {

	@Autowired
    @Qualifier(value = "jdbcTemplateAdm")
    private JdbcTemplate jdbcTemplate;
	
	private SecureRandom random = new SecureRandom();
	private final int ROWCOUNT = 1000;
	
	@Override
	public int insertData() throws Exception {
		int count = 0;
		try{
			for(int i=0; i < ROWCOUNT; i++) {
				count+=getJdbcTemplate().update("INSERT INTO contacts (name) VALUES (?)", generateWord());
			}
			return count;
		} catch(DataAccessException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Map<Long, String> getData() {
		Map<Long, String> map = new HashMap<>();
		
		map = (HashMap<Long, String>) getJdbcTemplate().query("select id, name from contacts", new ResultSetExtractor<Map>() {
			@Override
			public Map extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<Long,String> mapRes= new HashMap<Long,String>();
				while(rs.next()) {
					mapRes.put(rs.getLong("id"), rs.getString("name"));
				}
				return mapRes;
			}
		});		
		
		return map;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	private String generateWord() {		
		return new BigInteger(50, random).toString(32);
	}
}