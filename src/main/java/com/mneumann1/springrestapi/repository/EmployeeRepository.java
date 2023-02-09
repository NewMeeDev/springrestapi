package com.mneumann1.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mneumann1.springrestapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByName(String name);
	
	// SELECT * FROM table WHERE name="Marc" AND location="Germany"
	List<Employee> findByNameAndLocation(String name, String location);
	
	// SELECT * FROM table WHERE name LIKE %ram%'
	List<Employee> findBynameContaining(String keyword);
	
}
