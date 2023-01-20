package com.we2foodie.web.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.we2foodie.web.model.ResourceDTO;
import com.we2foodie.web.model.Resources;
import com.we2foodie.web.model.User;
import com.we2foodie.web.model.UserDTO;
import com.we2foodie.web.service.LoadResourcesImpl;
import com.we2foodie.web.service.UserServiceImpl;

@Controller
public class WelcomeController {

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	LoadResourcesImpl loadResourceImpl;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passworEncoder;

	@RequestMapping(value = { "/", "/index.html" })
	private String HandleWelcomePage(Model model) {
		
		Resources resources=loadResourceImpl.getMainImage("jumbotron_image");
		ResourceDTO resourceDto=modelMapper.map(resources, ResourceDTO.class);
		model.addAttribute("banner", resourceDto.getPath());
		return "index";
	}

	@GetMapping(value = { "/menu.html" })
	private String HandleMenuPage() {
		return "menu";
	}

	@GetMapping(value = { "/about.html" })
	private String HandleAboutPage() {
		return "about";
	}

	@GetMapping(value = { "/login" })
	private String HandleLoginPage(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken)
			return "login";
		else {
			String name = SecurityContextHolder.getContext().getAuthentication().getName();
			model.addAttribute("UserName", name);

			return "redirect:/inbox";
		}
	}

	@RequestMapping(value = { "/register" })
	private String HandleRegisterPage() {
		return "register";
	}

	@PostMapping(value = { "/register_save" })
	private String HandleRegistration(@ModelAttribute("p") UserDTO userDto, RedirectAttributes ra, Model model) {
		userDto.setPassword(this.passworEncoder.encode(userDto.getPassword()));
		User tempUser = modelMapper.map(userDto, User.class);
		User rUsr = userService.addUser(tempUser);
		UserDTO dtoUser = modelMapper.map(rUsr, UserDTO.class);
		model.addAttribute("module", dtoUser);
		ra.addFlashAttribute("message", "Registration Successful");
		return "redirect:/register";
	}

	@GetMapping(value = { "/inbox" })
	private String HandleSignin(@ModelAttribute("p") User user, Model model) {

		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("UserName", name);
		return "inbox";

	}

}
