package com.test.departmentProject.entity;

//Java Program to Illustrate Department File

//Annotations


//Importing required classes
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;

import org.hibernate.annotations.CacheConcurrencyStrategy;



//Class
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "department_db")

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	@NotNull
	private String departmentName;
	@NotNull
	private String departmentAddress;
	@NotNull
	@Size(min=3, message="departmentCode should have atleast 3 characters")
	private String departmentCode;
	
	//private String userName;
	//private String password;.
}
