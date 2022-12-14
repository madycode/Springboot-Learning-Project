
package com.test.departmentProject.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.departmentProject.api.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String username);
}
