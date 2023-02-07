package com.mneumann1.springrestapi.service;

import java.util.List;

import com.mneumann1.springrestapi.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getSingleEmployee(Long id);
	
	void deleteEmployee(Long id);
	
	Employee udateEmployee(Employee employee);
	
	List<Employee> getEmployeesByName(String name);
}
