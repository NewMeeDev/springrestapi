package com.mneumann1.springrestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
//import org.hibernate.validator.constraints.UniqueElements;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter		// lombok
@Setter		// lombok
@ToString	// lombok
@Entity		// JPA
@Table(name="tbl_employee")		// JPA
public class Employee {
	
	@Id // PRIMARY KEY
	@GeneratedValue(strategy=GenerationType.IDENTITY) // AUTO-INCREMENT
	private Long id;

	
	// @Column(name="name") --> optional, if the column-name should differ from java property-name
	// @JsonProperty("full_name") // an alias of the property, which can be used in the JSON payload of http requests like: { "full_name" : "Marc" }
	// @NotNull(message = "Name should not be null")
	// @NotEmpty(message = "Name should not be null or empty")
	@NotBlank(message = "Name should not be null, empty or whitespace")
	private String name;
	
	
	// @JsonIgnore // hide this property from the http-response
	private long age = 0L; // default value

	
	private String location;

	
	@Email(message = "Please enter the valid and unique email address")
	private String email;
	
	
	@NotBlank(message = "Department should not be null, empty or whitespace")
	private String department;
	
	
	@CreationTimestamp
	@Column(name="created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
}
