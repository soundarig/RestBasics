package com.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	

}
