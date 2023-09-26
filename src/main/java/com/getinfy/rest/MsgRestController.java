package com.getinfy.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/contact")
	public String contact() {
		
		return "+91 97 05 33 43 21";
	}
	
	
	@GetMapping("/welcome")
	public String getWelcome() {
		
		return "Welcome to our APP  ";
	}
	
	@GetMapping("/greet")
	public String getGreet() {
		
		return "Good evening ";
	}
	
	
	

}
