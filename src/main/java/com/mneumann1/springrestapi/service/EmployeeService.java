package com.mneumann1.springrestapi.service;

import java.util.List;


import com.mneumann1.springrestapi.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();
	
	Employee getSingleEmployee(Long id);
	
	Employee saveEmployee(Employee employee);
	
	Employee udateEmployee(Employee employee);
	
	void deleteEmployee(Long id);
	

}
