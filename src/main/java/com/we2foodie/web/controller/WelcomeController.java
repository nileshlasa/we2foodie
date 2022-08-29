package com.we2foodie.web.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
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

}
