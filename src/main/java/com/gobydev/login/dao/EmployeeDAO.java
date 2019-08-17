package com.gobydev.login.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gobydev.login.model.Employee;
import com.gobydev.login.repository.EmployeeRepository;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository er;
	
	/*save employee*/
	public Employee save( Employee employee ) {
		return er.save(employee);
	}	
	
	/*search all employees*/
	public List<Employee> findAll(){
		return er.findAll();
	}	
	
	/*get an employee by id*/
	public Employee findOne(Long id) {		
		return er.getOne(id);		
	}	
	
	/*delete an employee*/
	public void delete(Employee employee) {
		er.delete(employee);
	}
	
}
