package com.w.training.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w.training.beans.Book;

@RestController
@RequestMapping("/info")
public class BookInfoController {

	@RequestMapping("/all")
	List<Book> getAllBooks() {
		return Arrays.asList(
				new Book("Herbert Schildt", "Diving into Java", 4),
				new Book("Who moved my Cheese", "A Book about Change", 5),
				new Book("Three Men and the Sea", "Philosophy", 4)
				);
	}
	
}
