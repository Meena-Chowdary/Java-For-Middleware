package com.cts.swmvc;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.swmvc.dao.EmployeeRepository;
import com.cts.swmvc.model.Department;
import com.cts.swmvc.model.Employee;
import com.cts.swmvc.service.EmployeeService;
import com.cts.swmvc.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTestContextConfiguration {
	
	@TestConfiguration
	static class EmployeeServiceImpTestContextConfiguration{  //inner class
		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();//this needs dao but we are mocking actual  dao and providing mockdao for this
		}
	}
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean       //when actual repository is called this repository is used so that actual dao is not used which makes it unit testing
	private EmployeeRepository employeeRepository;
	
	@Before
	public void setUp() {
		Employee emp=new Employee("Meena","Chowdary",45000,LocalDate.now(),Department.DEVELOPMENT,"9010930815","meenachowdary@yahoo.com");
		Mockito.when(employeeRepository.findByMobileNumber(emp.getMobileNumber())).thenReturn(emp);
	}
	//Mocito.when(employeeRepository.findByMobileNumber(Mockito.anyString())).thenReturn(null):
	@Test
	public void whenValidMobileNumber_thenEmployeeShouldBeFound() {
		String mno="9010930815";
		Employee found=employeeService.findByMobileNumber(mno);
		assertThat(found.getMobileNumber()).isEqualTo(mno);
	}
	
	@Test
	public void whenInValidMobileNumber_thenEmployeeShouldBeFound() {
		String mno="1234567890";
		Employee found=employeeService.findByMobileNumber(mno);
		assertThat(found).isNull();
	}
	
}
