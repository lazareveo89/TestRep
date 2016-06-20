package com.test.service.impl;

import java.util.Map;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.dao.ContactDao;
import com.test.model.Contact;
import com.test.service.ContactService;

public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDao contactDao;
	
	@Override
	public JSONArray getAllContacts(String regExp) {
		Map<Long, String> map = getContactDao().getData();
		JSONArray jsonArray = new JSONArray();

		for(Map.Entry<Long, String> entry : map.entrySet()) {
			if(!entry.getValue().matches(regExp)) {
				Contact contact = new Contact();
				contact.setId(entry.getKey());
				contact.setName(entry.getValue());
				jsonArray.add(contact);
			}
		}
		return jsonArray;		
	}

	@Override
	public Integer insertData() throws Exception {
		try {
			return getContactDao().insertData();
		} catch(Exception e) {
			throw e;
		}
	}

	public ContactDao getContactDao() {
		return contactDao;
	}
}
