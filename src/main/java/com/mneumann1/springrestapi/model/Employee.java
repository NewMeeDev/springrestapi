package com.mneumann1.springrestapi.model;

import com.mneumann1.springrestapi.request.EmployeeRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_employee") // wenn Tabellenname <> Entity-Klassenname, dann muss man so dem Entity den Namen der Tabelle zuweisen
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JoinColumn(name = "department_id")
	@OneToOne
	private Department department;
	
	
	public Employee() {}
	
	
	public Employee(EmployeeRequest req) {
		
		this.name = req.getName();
		
	}

	
}
