package com.employeeservice.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/demo")
public class TestController {
	
	@GetMapping("/test")
	public String test() {
		return "demo running";
	}

}
