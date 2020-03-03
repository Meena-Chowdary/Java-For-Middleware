package com.cts.swmvc.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empId;
	
	@NotEmpty(message="first name cannot be null")
	@NotNull(message="first name cant be not null")
	private String firstName;
	
	@NotEmpty(message="last name cant be not empty")
	@NotNull(message="last name cant be null")
	private String lastName;
	
	@Min(value=25000,message="basic cant be less than 25000")
	@Max(value=50000,message="basic cant be more than 50000")
	private double basic;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate joinDate;
	
	@Enumerated(EnumType.STRING)
	private Department dept;
	
	@Pattern(regexp="[1-9][0-9]{9}",message="mobile num not correct")
	@NotNull(message="cant be null")
	private String mobileNumber;
	
	
	
	@Email(message="email must be a valid one")
	@NotNull(message="cant be null")
	private String email;

	public Employee() {
		super();
	}

	public Employee(
			@NotEmpty(message = "first name cannot be null") @NotNull(message = "first name cant be not null") String firstName,
			@NotEmpty(message = "last name cant be not empty") @NotNull(message = "last name cant be null") String lastName,
			@Min(value = 25000, message = "basic cant be less than 25000") @Max(value = 50000, message = "basic cant be more than 50000") double basic,
			LocalDate joinDate, Department dept,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile num not correct") @NotNull(message = "cant be null") String mobileNumber,
			@Email(message = "email must be a valid one") @NotNull(message = "cant be null") String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.basic = basic;
		this.joinDate = joinDate;
		this.dept = dept;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}



	public Long getEmpId() {
		return empId;
	}



	public void setEmpId(Long empId) {
		this.empId = empId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public double getBasic() {
		return basic;
	}



	public void setBasic(double basic) {
		this.basic = basic;
	}



	public LocalDate getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}



	public Department getDept() {
		return dept;
	}



	public void setDept(Department dept) {
		this.dept = dept;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	

}
