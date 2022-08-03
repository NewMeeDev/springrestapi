package com.mneumann1.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mneumann1.springrestapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
