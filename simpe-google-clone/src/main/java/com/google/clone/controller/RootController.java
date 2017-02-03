package com.google.clone.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.clone.model.InformationModel;
import com.google.clone.util.Helper;

@Controller
public class RootController {
	
	@Autowired
	private Helper helper;
	
	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView getStartPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("root");
		return mav;
	}
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView getStartPage(@RequestParam(value = "searchValue") String searchValue, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("root_search");
		List<InformationModel> list = helper.getFullInfo(searchValue);
		mav.addObject("information", list);
		return mav;
	}
}