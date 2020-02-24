package com.cts.swmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.swmvc.exception.InvalidVisitorException;
import com.cts.swmvc.model.Visitor;
import com.cts.swmvc.services.IVisitorService;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/vapi")
public class VisitorRestController {
	
	@Autowired
	private IVisitorService vServ;
	
	
	@PostMapping
	public ResponseEntity<Visitor> acceptVisitorDate(@RequestBody Visitor visitor) throws InvalidVisitorException {
		if(vServ.isValid(visitor))
			visitor=vServ.computeAge(visitor);
		return new ResponseEntity<Visitor>(visitor,HttpStatus.OK); //code200-OK
	}
	
	@ExceptionHandler(InvalidVisitorException.class)
	public ResponseEntity<String> handleInvalidVisitorException(InvalidVisitorException exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
