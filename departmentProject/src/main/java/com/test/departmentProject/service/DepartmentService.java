package com.test.departmentProject.service;

//Java Program to Illustrate DepartmentService File


//Importing required classes
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.departmentProject.entity.Department;



//Interface
@Service
public interface DepartmentService {

	// Save operation
	Department saveDepartment(Department department);

	// Read operation
	List<Department> fetchDepartmentList();

	// Update operation
	Department updateDepartment(Department department,
								Long departmentId);

	// Delete operation
	void deleteDepartmentById(Long departmentId);
	
	 public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException ;
	 
	 
}

