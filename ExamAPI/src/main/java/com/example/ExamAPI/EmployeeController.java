package com.example.ExamAPI;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
	@RequestMapping("/api")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();
    
    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
    	if (employee.getEmployeeId() == null || employee.getFirstName() == null ||
    	        employee.getLastName() == null || employee.getEmail() == null ||
    	        employee.getPhoneNumbers() == null || employee.getDoj() == null ||
    	        employee.getMonthlySalary() <= 0) {
    	        return ResponseEntity.badRequest().body("Invalid employee details. All fields are mandatory.");
    	    }
    	    
    	    // Add the employee
    	    employees.add(employee);
    	    
    	    return ResponseEntity.ok("Employee added successfully.");
    	}
    
    
    @GetMapping("/tax/{employeeId}")
    public ResponseEntity<EmployeeTaxDetails> getTaxDeduction(@PathVariable String employeeId) {
    	  Employee employee = findEmployeeById(employeeId);
    	    
    	    if (employee == null) {
    	        return ResponseEntity.notFound().build(); // Employee not found
    	    }
    	    
    	    // Calculate tax deduction
    	    double yearlySalary = employee.getYearlySalary();
    	    double taxAmount = EmployeeTaxCalculation.calculateTaxAmount(yearlySalary);
    	    double cessAmount = EmployeeTaxCalculation.calculateCessAmount(yearlySalary);
    	    
    	    // Create and return EmployeeTaxDetails
    	    EmployeeTaxDetails taxDetails = new EmployeeTaxDetails(
    	        employee.getEmployeeId(),
    	        employee.getFirstName(),
    	        employee.getLastName(),
    	        yearlySalary,
    	        taxAmount,
    	        cessAmount
    	    );
    	    
    	    return ResponseEntity.ok(taxDetails);
    	
    }
    private Employee findEmployeeById(String employeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId().equals(employeeId)) {
                return emp;
            }
        }
        return null; // Employee not found
    }
    private double calcualteYearlySalary(Employee employee) {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(employee.getDoj());

        int joiningYear = calendar.get(Calendar.YEAR);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        int monthsWorked = (currentYear - joiningYear) * 12 + Calendar.getInstance().get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
        int totalMonths = 12;

        if (monthsWorked < 0) {
            monthsWorked = 0;
        } else if (monthsWorked > totalMonths) {
            monthsWorked = totalMonths;
        }

        double totalSalary = employee.getMonthlySalary() * monthsWorked;

        return totalSalary;
    }

    }