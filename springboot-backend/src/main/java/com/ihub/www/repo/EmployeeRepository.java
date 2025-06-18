package com.ihub.www.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihub.www.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
	List<Employee> findByIsDeletedFalse();//fetching the non-deleted employees

	
}

