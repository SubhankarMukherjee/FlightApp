package com.flightreservation.controller;

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
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/showReg")
	public String showForm()
	{
		return "login/registerUser";
	}
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user)
		{
		userRepository.save(user);
		return "login/login";
	}
	
	@GetMapping("/showLogin")
	public String showLogin()
	{
		return "login/login";
	}
	
	@PostMapping("/login")
	public String loginModule(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap model)
		{
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
