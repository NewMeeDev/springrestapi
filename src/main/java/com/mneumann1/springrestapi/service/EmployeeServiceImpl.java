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
	public List<Employee> getEmployees(int pageNumber, int pageSize) {
		//Pageable pages = PageRequest.of(pageNumber, pageSize); --> ohne Sortierung 
		Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC, "id"); 
		return empRepository.findAll(pages).getContent();
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
		Sort sort = Sort.by(Sort.Direction.ASC, "id"); // Sort kann auch weggelassen werden, wenn keine Sortierung notwendig ist
		return empRepository.findBynameContaining(name, sort);
	}


	@Override
	public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
		return empRepository.getEmployeesBynameAndLocation(name, location);
	}


	@Override
	public Integer deleteByEmployeeName(String name) {
		return empRepository.deleteEmployeeByName(name);
	}

	
}










