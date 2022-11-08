package com.test.departmentProject.repository;

//Java Program to Illustrate DepartmentRepository File


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.departmentProject.entity.Department;


//Annotation
@Repository

//Interface
public interface DepartmentRepository
	extends JpaRepository<Department, Long> {
	
	//Department findByUserName(String departmentname);
	
}

