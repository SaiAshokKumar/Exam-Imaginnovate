package com.example.ExamAPI;

public class EmployeeTaxCalculation {
	

 public static double calculateTaxAmount(double yearlySalary) {
		
	   double taxAmount = 0;

	    if (yearlySalary <= 250000) {
	        // No tax for yearly salary <= 250000
	        taxAmount = 0;
	    } else if (yearlySalary <= 500000) {
	        // 5% Tax for yearly salary > 250000 and <= 500000
	        taxAmount = (yearlySalary - 250000) * 0.05;
	    } else if (yearlySalary <= 1000000) {
	        // 10% Tax for yearly salary > 500000 and <= 1000000
	        taxAmount = 25000 + (yearlySalary - 500000) * 0.1;
	    } else {
	        // 20% Tax for yearly salary > 1000000
	        taxAmount = 125000 + (yearlySalary - 1000000) * 0.2;
	    }

	    return taxAmount;
	}
	      
	 
	    
	    public static double calculateCessAmount(double yearlySalary) {
			
	    	
	    	double cessAmount = 0;
	    	

	        if (yearlySalary > 2500000) {
	            
	            cessAmount = (yearlySalary - 2500000) * 0.02;
	        }
	       

	        return cessAmount;
}

}