package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	//this is access by all the users and admin without username and password
	@GetMapping("/")
	public String welcome() {
		return "<h2> Welcome to the Home Page </h2>";
		
	}
	//this is access by admin only
	@GetMapping("/admin")
	public String adminProcess() {
		return "<h2> Welcome admin</h2>";
		 
	}
	// this is access by user as well as admin
	@GetMapping("/user")
	public String userProcess() {
		return "<h2> Welcome User </h2>";
		
	}
}
