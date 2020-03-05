package com.w.training.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.w.training.beans.BookCatalogItem;

@Service
public class BookService {
	
	@Autowired
	RestTemplate template;
	
	
	public BookCatalogItem getBook() {
		return new BookCatalogItem("Alchemist", "A Book about life", 4);
	}

	public List<Object> getAllBooks() {
//		The URL to hit for the second micro-service
		String urlToHit = "http://localhost:8084/info/all";
//		String urlToHit = "http://infoservice/info/all";
		
//		Call the other micro service to fetch data of all books
		return  Arrays.asList(template.getForObject(urlToHit, Object[].class));
	}
}
