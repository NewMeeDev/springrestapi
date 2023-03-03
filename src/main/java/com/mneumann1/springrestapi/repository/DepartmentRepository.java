/**
 * 
 */
package com.mneumann1.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mneumann1.springrestapi.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
