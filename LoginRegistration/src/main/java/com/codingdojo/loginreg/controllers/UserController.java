package com.codingdojo.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.services.UserService;

@Controller
@RequestMapping("")
public class UserController {
	private UserService uS;
	
	public UserController(UserService uS){
		this.uS = uS;
	}
	
	@GetMapping("")
	public String showRegister( @ModelAttribute("user") User user,HttpSession session ){
		session.invalidate();
		return "register";
	}
	
	@PostMapping("")
	public String register( @Valid @ModelAttribute("user") User user, BindingResult res, Model model ){
		if(res.hasErrors()) {
			return "register";
		}else {
			if(!user.getPassword().equals(user.getConfirm()) ) {
				System.out.println("PASSWORDS DONT MATCH");
				model.addAttribute("userError","Password and Password Confirmation must match!");				
				return "register";
			}else {
				String pw = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
				user.setPassword(pw);				
				User exists = uS.findByEmail(user.getEmail());
				
				if(exists != null) {
					model.addAttribute("userError","A user with this email already exists!");
					return "register";
				}else {
					uS.create(user);
					return "redirect:/";				
				}				
			}
		}
	}
	
	@PostMapping("/login")
	public String login( @RequestParam("email") String email,@RequestParam("password") String password, Model model, HttpSession session ){
		if(email.length() < 1){
			model.addAttribute("loginError","Invalid Credentials!");
			model.addAttribute("user",new User());
			return "register";
		}
		if(password.length() < 8){
			model.addAttribute("loginError","Invalid Credentials!");
			model.addAttribute("user",new User());
			return "register";
		}
		
		User u = uS.findByEmail(email); 
		
		if(u == null) {
			model.addAttribute("loginError","Invalid Credentials!");
			model.addAttribute("user",new User());
			return "register";			
		}else {
			boolean matches = BCrypt.checkpw(password,u.getPassword());
			
			if(matches) {
				System.out.println("SOME USERS ID: "+u.getId());
				
				session.setAttribute("user",u.getName());
				return "redirect:/tasks";
			}else {
				model.addAttribute("loginError","Invalid Credentials!");
				model.addAttribute("user",new User());
				return "register";	
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
