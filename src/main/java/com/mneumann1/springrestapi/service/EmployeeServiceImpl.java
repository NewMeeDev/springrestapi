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
	private EmployeeRepository empRepository;
	
	
	@Override
	public List<Employee> getEmployees() {
		return empRepository.findAll();
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepository.save(employee);
	}


	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee = empRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for the id " + id);
	}


	@Override
	public void deleteEmployee(Long id) {
		empRepository.deleteById(id);
	}


	@Override
	public Employee udateEmployee(Employee employee) {
		return empRepository.save(employee);
	}


	@Override
	public List<Employee> getEmployeesByName(String name) {
		return empRepository.findByName(name);
	}


	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		return empRepository.findByNameAndLocation(name, location);
	}


	@Override
	public List<Employee> getEmployeesByKeyword(String name) {
		return empRepository.findBynameContaining(name);
	}
	
	
	
	
}










