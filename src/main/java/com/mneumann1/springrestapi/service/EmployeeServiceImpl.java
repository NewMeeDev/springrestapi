package com.mneumann1.springrestapi.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mneumann1.springrestapi.model.Employee;
import com.mneumann1.springrestapi.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	
	@Override
	public List<Employee> getEmployees() {

		return empRepository.findAll();//.getContent();
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
	public Employee saveEmployee(Employee employee) {
		return empRepository.save(employee);
	}
	

	@Override
	public Employee udateEmployee(Employee employee) {
		return empRepository.save(employee);
	}
	
	
	@Override
	public void deleteEmployee(Long id) {
		empRepository.deleteById(id);
	}	
	
}










