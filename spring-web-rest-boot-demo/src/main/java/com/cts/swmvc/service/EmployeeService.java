package com.cts.swmvc.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.swmvc.exception.EmployeeException;
import com.cts.swmvc.model.Department;
import com.cts.swmvc.model.Employee;
@Service
public interface EmployeeService {
	Employee add(Employee emp) throws EmployeeException;
	Employee save(Employee emp) throws EmployeeException;
	void deleteBy(Long empId);
	
	Employee findById(Long empId);
	Employee findByMobileNumber(String mobileNumber);
	Employee findByEmail(String email);
	
	List<Employee> findAll();
	List<Employee> findAllByDept(Department dept);
	List<Employee> findAllByJoinDate(LocalDate joinDate);
	
	List<Employee> findAllByBasicRange(double lb,double ub);
	
	
}
