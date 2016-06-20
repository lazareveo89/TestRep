package com.test.dao;

import java.util.Map;

public interface ContactDao {
	public int insertData() throws Exception;
	public Map<Long, String> getData();
}