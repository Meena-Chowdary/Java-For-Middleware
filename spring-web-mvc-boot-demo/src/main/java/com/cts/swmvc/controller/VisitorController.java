package com.cts.swmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmvc.model.Visitor;
import com.cts.swmvc.services.IVisitorService;

@Controller
@RequestMapping("/visitor")
public class VisitorController {
	
	@Autowired
	private IVisitorService vServ;
	
	@GetMapping
	public String showVisitorForm() {
		return "visitorInputPage";
	}
	
	@PostMapping
	public ModelAndView acceptVisitorDate(@ModelAttribute Visitor visitor) {
		visitor=vServ.computeAge(visitor);
		return new ModelAndView("visitorOutputPage","v",visitor);
	}
	
}
