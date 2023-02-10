package com.mneumann1.springrestapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mneumann1.springrestapi.model.Employee;

@Repository
// wenn Paging und Sorting nicht benötigt wird, dann kann man hier auch JpaRepository<T, ID> als Basisklasse verwenden 
// dann sind die Methoden im Service und im Controller schlanker (weniger Parameter)
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	List<Employee> findByName(String name);
	
	// SELECT * FROM table WHERE name="Marc" AND location="Germany"
	List<Employee> findByNameAndLocation(String name, String location);
	
	// SELECT * FROM table WHERE name LIKE %ram%'
	List<Employee> findBynameContaining(String keyword, Sort sort);
	
	// SELECT * FROM table WHERE name = 'Name' OR location = 'Location'
	@Query("FROM tbl_employee WHERE name = :name OR location = :location")
	List<Employee> getEmployeesBynameAndLocation(@Param("name") String name, @Param("location") String location);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM tbl_employee WHERE name = :name")
	int deleteEmployeeByName(String name);
	
}
