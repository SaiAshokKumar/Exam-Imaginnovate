package com.example.ExamAPI;

import lombok.Data;

@Data
public class EmployeeTaxDetails {
	private String employeeId;
    private String firstName;
    private String lastName;
    private double yearlySalary;
    private double taxAmount;
    private double cessAmount;
    
    public EmployeeTaxDetails() {
    }

	public EmployeeTaxDetails(String employeeId, String firstName, String lastName, double yearlySalary,
			double taxAmount, double cessAmount) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
	}

	
	    }

