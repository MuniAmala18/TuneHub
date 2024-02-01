package com.tunehub.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class NavController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	@GetMapping("/newSong")
	public String newSong() {
		return "newSong";
	}
	@GetMapping("/overview")
	public String overview() {
		return "overview";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/adminHome")
	public String adminHome() {
		return "adminHome";
	}
	@GetMapping("/customerHome")
	public String customerHomer(){
		return "customerHome";
	}
	
}
