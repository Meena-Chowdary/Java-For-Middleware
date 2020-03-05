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

import com.cts.mw.model.Registration;
import com.cts.mw.service.RegistrationService;
@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	RegistrationService service;

	@GetMapping
	List<Registration> getAllRegistrations() {
		return service.getAllRegistrations();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/reg")
	void addRegistration(@RequestBody Registration registration) {
		service.addRegistration(registration);
	}
	
	@RequestMapping("/registration/{id}")
	Optional<Registration> getRegistrationDetailsByID(@PathVariable int id) {
		return service.getRegistrationDetailsByID(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/regis/")
	void updateRegistration(@RequestBody Registration registration) {
		service.updateRegistration(registration);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/registration/{id}")
	void deleteRegistration(@PathVariable int id) {
		service.deleteRegistration(id);
	}
	
	
	@RequestMapping("/registrations/username/{username}")
	Registration getUserByUserName(@PathVariable String username)
	{
		return service.getRegistrationByUserName(username);
	}
	
}