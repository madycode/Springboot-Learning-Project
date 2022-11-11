package com.test.departmentProject.service;

//Java Program to Illustrate DepartmentServiceImpl File


//Importing required classes
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.departmentProject.entity.Department;
import com.test.departmentProject.repository.DepartmentRepository;



//Annotation
@Service

//Class

public class DepartmentServiceImpl
	implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	// Save operation
	@Override
	@Transactional(rollbackForClassName = {"NullPointerException", "ClassCastException"})
	public Department saveDepartment(Department department)
	{
		return departmentRepository.save(department);
	}

	// Read operation
	@Override 
	public List<Department> fetchDepartmentList()
	{
		return (List<Department>)
			departmentRepository.findAll();
	}

	// Update operation
	@Override
	public Department
	updateDepartment(Department department,
					Long departmentId)
	{
		Department depDB
			= departmentRepository.findById(departmentId)
				.get();

		if (Objects.nonNull(department.getDepartmentName())
			&& !"".equalsIgnoreCase(
				department.getDepartmentName())) {
			depDB.setDepartmentName(
				department.getDepartmentName());
		}

		if (Objects.nonNull(
				department.getDepartmentAddress())
			&& !"".equalsIgnoreCase(
				department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(
				department.getDepartmentAddress());
		}

		if (Objects.nonNull(department.getDepartmentCode())
			&& !"".equalsIgnoreCase(
				department.getDepartmentCode())) {
			depDB.setDepartmentCode(
				department.getDepartmentCode());
		}

		return departmentRepository.save(depDB);
	}

	// Delete operation
	@Override
	public void deleteDepartmentById(Long departmentId)
	{
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		
		Department dept=departmentRepository.findById(departmentId).get();
		
		if(dept!=null) {
			return dept;
		}else {
			throw new NoSuchElementException("Department not found with id : "+departmentId);
		}
	
		//return departmentRepository.findById(departmentId).get();
		
		
	}
	
	
}

