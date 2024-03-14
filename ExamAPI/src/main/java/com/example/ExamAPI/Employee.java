package com.example.ExamAPI;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
	private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> phoneNumbers;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date doj;
    private double monthlySalary;
    
    public Employee() {
    }
	public Employee(String employeeId, String firstName, String lastName, String email, List<String> phoneNumbers,
			Date doj, double monthlySalary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.doj = doj;
		this.monthlySalary = monthlySalary;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	@SuppressWarnings("deprecation")
	public double getYearlySalary() {
		int m = doj.getMonth();
		int factor = 1;
		if(m < 3) {
			factor = 2 - m;
		} else  {
			factor = 14 - m;
		}
		return this.monthlySalary * factor;
	}
	
	}
    
    
	
