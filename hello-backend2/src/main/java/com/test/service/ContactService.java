package com.test.service;


import org.json.simple.JSONArray;


public interface ContactService {
	public Integer insertData() throws Exception;
	public JSONArray getAllContacts(String regExp);
}
