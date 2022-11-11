package com.test.departmentProject.service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.test.departmentProject.entity.Department;

@Repository
public class DepartmentCustomServiceImpl implements DepartmentCustomService {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Department findByDepartmentName(String department_name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql1 = "from Department where department_name=:department_name";
		// String sql = "select department_name from department_db d where
		// d.department_name = department_name";
		final TypedQuery<Department> query = entityManager.createQuery(sql1, Department.class);
		query.setParameter("department_name", department_name);
		return query.getSingleResult();
	}

}
