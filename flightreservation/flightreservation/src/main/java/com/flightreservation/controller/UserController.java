package com.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entities.User;
import com.flightreservation.repository.UserRepository;



@Controller
public class UserController {
	private static Logger LOGGER= LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserRepository userRepository;

	@GetMapping("/showReg")
	public String showForm()
	{
		LOGGER.info("Inside method: showForm()");
		return "login/registerUser";
	}
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user)
		{
		LOGGER.info("Inside method: registerUser()");
		userRepository.save(user);
		return "login/login";
	}
	
	@GetMapping("/showLogin")
	public String showLogin()
	{
		LOGGER.info("Inside method: showLogin()");
		return "login/login";
	}
	
	@PostMapping("/login")
	public String loginModule(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap model)
		{
		LOGGER.info("Inside method: loginModule()");
		LOGGER.info("Email:{} and Password: {}",email,password);
		User user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password))
		{
			return "findFlights";
		}
		else
		{
			model.addAttribute("msg", "Incorrect Credential");
			return "login/login";
		}
		
	}
	
}
