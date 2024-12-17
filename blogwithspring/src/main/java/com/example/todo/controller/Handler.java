package com.example.todo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.todo.model.Blogattr;
import com.example.todo.model.UserRegister;
import com.example.todo.service.Blogserv;
import com.example.todo.service.Userserv;

@Controller
public class Handler {

	@Autowired
	private Blogserv blogserv;
	
	@Autowired
	private Userserv userserv;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Welcome To Home");
		return "/views/index";
	}
	
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "login");
		
		return "/views/login";
	}
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("register", new UserRegister());
		model.addAttribute("title", "register");
		return "/views/register";
	}
	
	@PostMapping("/register")
	public String registerpost(@ModelAttribute("register") UserRegister register, Model model) {
		userserv.saveUser(register);
		return "redirect:/login";
	}
	
	
	
	
	@GetMapping("/addblog")
	public String addblog(Model model) {
		model.addAttribute("title", "addblog");
		model.addAttribute("addblog", new Blogattr());
		return "/views/addblog";
	}
	
	@PostMapping("/addblog")
	public String addblogpost(@ModelAttribute("addblog") Blogattr blogattr, Model model){
		blogserv.saveblog(blogattr);
		return "redirect:/listblog";
	}
	
	@GetMapping("/listblog")
	public String listblog(Model model) {
		model.addAttribute("title", "listblog");
		model.addAttribute("listofblog",blogserv.listblog());
		return "/views/listblog";
	}
	
	@GetMapping("/profile")
	public String profile(Model model,Principal principal) {
		model.addAttribute("title", "Profile");
		model.addAttribute("email", principal.getName());
		model.addAttribute("details", userserv.findbyemail(principal.getName()));
		return "/views/profile";
	}
}
