package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {

		@GetMapping("/")
		public String welocom() {
			return "Welcome to SBI Bank.....";
		}
		
		@GetMapping("/transfer")
		public String tranfer() {
			return "Fund Transfer initiated ....!!";
			
		}
		
		@GetMapping("balance")
		public String balance() {
			return "Your Account Balance = 10000 INR";
		}
		
		@GetMapping("/about")
		public String aboutus() {
			return "SBI Bank managing by Indian Central Govt";
		}
}
