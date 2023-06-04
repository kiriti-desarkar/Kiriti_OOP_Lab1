package com.greatlearning.main;

import java.util.Scanner;

import com.greatlearning.interfaces.ICredentials;
import com.greatlearning.model.Employee;
import com.greatlearning.services.CredentialService;

public class Driver {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		//System.out.println("Hello Everyone!");
		 
		Employee employee = new Employee("Kiriti","Desarkar");
		
		displayMenu(employee);
       
        int option = scanner.nextInt();
        //System.out.println(option);
        
        String[] departments = {"tech","admin","hr","legal"};
        String department = departments[option-1];
        
        ICredentials credentialService = new CredentialService();
        String emailAddress = credentialService.generateEmailAddress(employee,department);
        employee.setEmail(emailAddress); 
        
        String password = credentialService.generatePassword();
        employee.setPassword(password);
        
        credentialService.showCredentials(employee);
	}

	private static void displayMenu(Employee employee) {
		System.out.println("Hello " + employee.getFirstName() +","
    	+ "Please enter the department from following(1-4)");
		System.out.println("1.Technical");
		System.out.println("2.Admin");
		System.out.println("3.Human Resource");
		System.out.println("4.Legal");
	}

}
