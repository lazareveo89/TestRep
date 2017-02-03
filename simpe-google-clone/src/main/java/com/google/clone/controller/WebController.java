package com.google.clone.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.clone.util.Helper;

@Controller
public class WebController {
	
	@Autowired
	private Helper helper;
	
	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView getStartIndexPage() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public void startIndexPage(@RequestParam(value = "indexUrl") String indexUrl, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("url", indexUrl);
		helper.getInfo(indexUrl);
		response.sendRedirect("/simpe-google-clone/home");
	}
}