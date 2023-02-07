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

import com.mneumann1.springrestapi.model.Employee;
import com.mneumann1.springrestapi.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Value("${app.name: Employee Tracker}") // Unterlassungswert
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	//localhost:8080/api/v1/version
	@GetMapping("/version")
	public String getAppdetails() {
		return appName + " (" + appVersion + ")";
	}

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
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<>(empService.saveEmployee(employee), HttpStatus.CREATED);
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
	
	@GetMapping("employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
		return new ResponseEntity<List<Employee>>(empService.getEmployeesByName(name), HttpStatus.OK);
	}
	
	@GetMapping("employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name, @RequestParam String location) {
		return new ResponseEntity<List<Employee>>(empService.getEmployeesByName(name, location), HttpStatus.OK);
	}
}
