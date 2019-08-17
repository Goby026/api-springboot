package com.gobydev.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gobydev.login.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
