package com.we2foodie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.we2foodie.web.model.User;
import com.we2foodie.web.service.UserServiceImpl;

@Controller
public class WelcomeController {
	
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value={"/","/index.html"})
	private String HandleWelcomePage()
	{
		return "index";
	}
	
	@RequestMapping(value={"/menu.html"})
	private String HandleMenuPage()
	{
		return "menu";
	}
	
	@RequestMapping(value={"/about.html"})
	private String HandleAboutPage()
	{
		return "about";
	}
	@RequestMapping(value={"/login"})
	private String HandleLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value={"/register"})
	private String HandleRegisterPage()
	{
	return "register";
	}
	
	@PostMapping(value={"/register_save"})
	private String HandleRegistration(@ModelAttribute("p") User user, Model model)
	{
		User tempUser;
		tempUser = userService.addUser(user);
		model.addAttribute("module",tempUser);
	return "register";
	}

}
