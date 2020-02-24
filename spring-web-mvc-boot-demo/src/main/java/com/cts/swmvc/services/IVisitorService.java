package com.cts.swmvc.services;

import com.cts.swmvc.exception.InvalidVisitorException;
import com.cts.swmvc.model.Visitor;

public interface IVisitorService {
	boolean isValid(Visitor visitor) throws InvalidVisitorException;
	Visitor computeAge(Visitor visitor);
}
