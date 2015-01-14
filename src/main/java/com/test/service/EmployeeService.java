package com.test.service;

import java.sql.SQLException;
import java.util.List;

import com.test.model.Employee;

public interface EmployeeService {
	
	public void createNewEmployee(Employee employee) throws SQLException;
	public void removeEmployee(Long employeeNumber)throws SQLException;
	public List<Employee> getAllEmployees() throws SQLException;
	public Employee findEmployeeById(Long employeeNumber);
	public void updateEmployee(Employee employee) throws SQLException;

}
