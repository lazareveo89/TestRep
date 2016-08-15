package com.test.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.test.secure.model.User;
import com.test.secure.service.UserService;

@Controller
@RequestMapping(value="/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(Model model, @RequestParam String login) {
        model.addAttribute("user", login);
        return "welcome";
    }
	
	@RequestMapping(value = "/checkUser", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody User checkUser(@RequestBody String user) {
			return getUserService().checkUser(new Gson().fromJson(user, User.class));
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public void addUser(@RequestBody User user) {
		getUserService().addUser(user);
	}
	
	public UserService getUserService() {
		return userService;
	}
}