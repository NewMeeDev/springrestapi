package com.mneumann1.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mneumann1.springrestapi.model.Department;
import com.mneumann1.springrestapi.model.Employee;
import com.mneumann1.springrestapi.repository.DepartmentRepository;
import com.mneumann1.springrestapi.repository.EmployeeRepository;
import com.mneumann1.springrestapi.request.EmployeeRequest;
import com.mneumann1.springrestapi.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private EmployeeRepository eRepo;
	
	@Autowired
	private DepartmentRepository dRepo;
	

	//localhost:8080/api/v1/employees
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(empService.getEmployees(), HttpStatus.OK);
	}

	//localhost:8080/api/v1/employees/1234
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(empService.getSingleEmployee(id), HttpStatus.OK);
	}
	
	//localhost:8080/api/v1/employees
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest empRequest) {
		Department dept = new Department();
		dept.setName(empRequest.getDepartment());
		
		dept = dRepo.save(dept);
		
		Employee employee = new Employee(empRequest);
		employee.setDepartment(dept);
		
		employee = eRepo.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	
	//localhost:8080/api/v1/employees/1234
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(empService.udateEmployee(employee), HttpStatus.OK);
	}
		
	//localhost:8080/api/v1/employees?id=1234
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
}
