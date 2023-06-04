package com.greatlearning.interfaces;

import com.greatlearning.model.Employee;

public interface ICredentials {
	
	String generatePassword();
	
	String generateEmailAddress(Employee employee,String department);
	
	void showCredentials(Employee employee);

}
