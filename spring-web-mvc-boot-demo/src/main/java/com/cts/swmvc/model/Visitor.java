package com.cts.swmvc.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Visitor {
	private String firstName;
	private String lastName;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate dateOfBirth;
	private int age;
	
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
