package com.w.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {

	@Autowired
	RestTemplate template;
	
	@HystrixCommand(fallbackMethod = "stillWorks")
	String getData() {
		String urlOfAnotherService = "http://localhost:8084/info/all";
		
		
		return template.getForObject(urlOfAnotherService, String.class);
	}
	
	String stillWorks() {
		return "Alchemist, Book on life, 4";
	}
}
