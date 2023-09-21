package com.spring.security.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.models.FirstNamecomparator;
import com.spring.security.models.Student;

@RestController
public class HomeController {

	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/public")
	public String normal() {
		return "public";
	}
	

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
