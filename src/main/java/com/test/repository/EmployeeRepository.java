package com.test.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.test.model.Employee;

public interface EmployeeRepository {
	
	
	
	public Map<String,Object> getEmployeeByNumberAsMap(Long empNumber);
	public List<Map<String, Object>> getAllEmployeesAsMap();
	public String findNameByEmployeeNumber(Long employeeNumber);
	public Employee findEmployeeByNumber(Long employeeNumber) ;
	public List<Employee> findAllEmployees() ;
	public void save(Employee employee) ;
	public void update(Employee employee);
	public void delete(Long employeeNumber) ;
}
