package com.greatlearning.services;

import java.security.SecureRandom;
import java.util.Random;

import com.greatlearning.interfaces.ICredentials;
import com.greatlearning.model.Employee;

public class CredentialService implements ICredentials {

	@Override
	public String generatePassword() {
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "!@#$%^&*_=+-/.?<>)";
		String[] values = {capitalLetters,smallLetters,numbers,specialCharacters};
		
		SecureRandom random = new SecureRandom();
		String password="";
		for(int i=0;i<2;i++) {
			for(String value:values) {
				password = password + value.charAt(random.nextInt(value.length()));
			}
		}
		return password;
	}

	@Override
	public String generateEmailAddress(Employee employee, String department) {
		String emailAddress = employee.getFirstName().toLowerCase() + "." 
				+ employee.getLastName().toLowerCase() + "@"
				+ department + ".abc.com";
		return emailAddress;
	}

	@Override
	public void showCredentials(Employee employee) {
		System.out.println("Dear employee " + employee.getFirstName() + ",");
		System.out.println("Here are your credentials");
		System.out.println("Your Email -> " + employee.getEmail());
		System.out.println("Your Password -> " + employee.getPassword());

	}

}
