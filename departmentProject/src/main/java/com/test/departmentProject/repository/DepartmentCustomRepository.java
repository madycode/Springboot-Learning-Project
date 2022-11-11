package com.test.departmentProject.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.departmentProject.entity.Department;

@Repository
public interface DepartmentCustomRepository {

	List<Department> findByDepartmentName(String deptName);
}
