package com.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.LoginForm;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadLoginForm(Map model) {
		
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		
		return "loginform";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model) {
		String userName = "Admin";
		String password = "root";
		if (result.hasErrors()) {
			return "loginform";

		}
		loginForm = (LoginForm) model.get("loginForm"); //to retrive the correct Login Form
		if (!loginForm.getUsername().equals(userName)
				|| !loginForm.getPassword().equals(password)) {
			return "loginerror";
		}
		model.put("loginForm", loginForm);
		return "loginsuccess";
	}

}
