package com.test.controller;


import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.ContactService;

@Controller
@RequestMapping(value = "/hello")
public class BackController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertData(HttpServletResponse response) {
	try{
		int i = getContactService().insertData();
		if(i != 0) {
			response.setStatus(200);
		} else {
			response.setStatus(200);
			response.setHeader("Result", "Data weren't inserted");
		}
	}catch(Exception e) {
		response.setStatus(404);
		response.setHeader("Error", e.getMessage());
		}
	}
	
	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public @ResponseBody JSONObject getData(@RequestParam(value = "nameFilter") String nameFilter) {
		JSONArray resultData = getContactService().getAllContacts(nameFilter);
		JSONObject resultAll = new JSONObject(); 
		resultAll.put("contacts", resultData);
		return resultAll;
	}
	
	public ContactService getContactService() {
		return contactService;
	}
}