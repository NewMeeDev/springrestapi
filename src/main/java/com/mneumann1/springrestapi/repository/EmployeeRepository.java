package com.mneumann1.springrestapi.repository;


//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;


import com.mneumann1.springrestapi.model.Employee;

@Repository
// wenn Paging und Sorting nicht benötigt wird, dann kann man hier auch JpaRepository<T, ID> als Basisklasse verwenden 
// dann sind die Methoden im Service und im Controller schlanker (weniger Parameter)
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	
}
