package com.mneumann1.springrestapi.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name="tbl_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//@JsonProperty("full-name") --> ändert den Bezeichner des JSON-Keys (z.B.: { "full-name": "Hans Meier" })
	@NotBlank(message="Name cannot be null or empty")
	private String name;
	
	//@JsonIgnore --> wird im JSON ausgeblendet
	private Long age = 0L; // default = 0
	
	private String location; 
	
	@NotEmpty(message = "Email cannot be null or empty")
	@Email(message="Please enter the valid email address")
	private String email;
	
	@NotBlank(message="Department should not be null")
	private String department;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
}
