package com.mneumann1.springrestapi.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.mneumann1.springrestapi.model.Employee;
import com.mneumann1.springrestapi.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Value("${app.name: Employee Tracker}")
	private String appName;
	
	@Value("${app.version: version1}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppDetails() {
		return String.format("%s - %s", appName, appVersion);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		return new ResponseEntity<Employee>(employeeService.getSingleEmployee(id), HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

}
