package com.mneumann1.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mneumann1.springrestapi.model.Employee;
import com.mneumann1.springrestapi.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee saveEmployee (Employee employee) {
		return employeeRepository.save(employee);
	};

	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} 
		throw new RuntimeException(String.format("Employee not found for the id: %s", id));
	}
	
	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}
