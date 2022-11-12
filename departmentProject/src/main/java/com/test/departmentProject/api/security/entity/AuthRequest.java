
package com.test.departmentProject.api.security.entity;

import javax.persistence.Cacheable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor

@NoArgsConstructor

@Cacheable

@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class AuthRequest {

	private String userName;
	private String password;
}
