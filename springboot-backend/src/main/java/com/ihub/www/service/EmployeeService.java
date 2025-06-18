package com.ihub.www.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ihub.www.exception.ResourceNotFoundException;
import com.ihub.www.model.Employee;
import com.ihub.www.repo.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findByIsDeletedFalse();
	}
	
	public Employee addEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	

	public Employee getEmployeeById(long id)
	{
		return employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Id Not Found"));
	}
	
	public ResponseEntity<Employee> updateEmployeeById(long id,Employee employee)
	{
		System.out.println(employee);
		Employee oldEmp=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id Not Found"));
		
		oldEmp.setFirstName(employee.getFirstName());
		oldEmp.setLastName(employee.getLastName());
		oldEmp.setEmail(employee.getEmail());
		
		Employee updateEmp=employeeRepository.save(oldEmp);
		
		return ResponseEntity.ok(updateEmp);
	}
	
	public ResponseEntity<HttpStatus> deleteEmployee(long id)
	{
		Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee Does not Exit"));
		
		employee.setIsDeleted(true);
		employee.setDeletedAt(LocalDate.now()); //replaced by employeeRepository.delete(employee);
		employeeRepository.save(employee);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
