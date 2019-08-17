package com.gobydev.login.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gobydev.login.dao.EmployeeDAO;
import com.gobydev.login.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController{

	@Autowired
	EmployeeDAO edao;

//	save employee
	@PostMapping("/employees")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return edao.save(employee);
	}

//	get all  employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return edao.findAll();
	}

//	get employee by id	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Employee emp=edao.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}

//	update an employee by id
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Employee emp) {
		Employee e = edao.findOne(id);
		if (e.equals(null)) {
			return ResponseEntity.notFound().build();
		}

		e.setName(emp.getName());
		e.setDesignation(emp.getDesignation());
		e.setExpertise(emp.getExpertise());

		return ResponseEntity.ok().body(edao.save(e));
	}

//	delete an employee by id
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long id) {
		Employee e = edao.findOne(id);
		if (e.equals(null)) {
			return ResponseEntity.notFound().build();
		}

		edao.delete(e);

		return ResponseEntity.ok().build();
	}

}
