package com.cts.mw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mw.model.User;
import com.cts.mw.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService service;

	@GetMapping
	List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	void addUser(@RequestBody User user) {
		service.addUser(user);
	}
	
	@RequestMapping("/users/{id}")
	Optional<User> getUserDetailsByID(@PathVariable int id) {
		return service.getUserDetailsByID(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/")
	void updateUser(@RequestBody User user) {
		service.updateUser(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
	}
	
	
	@RequestMapping("/users/username/{username}")
	User getUserByUserName(@PathVariable String username)
	{
		return service.getUserByUserName(username);
	}
	
}