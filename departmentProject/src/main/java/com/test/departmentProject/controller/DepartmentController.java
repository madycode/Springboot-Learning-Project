package com.test.departmentProject.controller;

//Java Program to Illustrate DepartmentController File

import java.util.List;
import javax.validation.Valid;
//Importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.test.departmentProject.api.security.entity.AuthRequest;
import com.test.departmentProject.api.security.util.JwtUtil;
import com.test.departmentProject.entity.Department;
import com.test.departmentProject.repository.DepartmentCustomRepository;
import com.test.departmentProject.service.DepartmentCustomService;
import com.test.departmentProject.service.DepartmentNotFoundException;
import com.test.departmentProject.service.DepartmentService;

//Annotation
@RestController

//Class
public class DepartmentController {

	// Annotation

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private DepartmentCustomService departmentCustomService;

	@Autowired
	private DepartmentService departmentService;

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/")
	public String welcome() {
		return "Welcome to MahadevTecheii !!";
	}

	// Save operation
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	// Read operation
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		return departmentService.fetchDepartmentList();
	}

	// Update operation
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
		return departmentService.updateDepartment(department, departmentId);
	}

	// Delete operation
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Deleted Successfully";
	}

	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable(name = "id") Long departmentId)
			throws DepartmentNotFoundException {
		System.out.println("==============2============================================");
		return new ResponseEntity<>(departmentService.getDepartmentById(departmentId), HttpStatus.OK);
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

	// Read operation

	@RequestMapping(value = "/departments/name/{department_name}", method = RequestMethod.GET)
	public ResponseEntity<Department> findByDepartmentName(
			@PathVariable(value = "department_name") String department_name) {
		return new ResponseEntity<>(departmentCustomService.findByDepartmentName(department_name), HttpStatus.OK);

	}

}
