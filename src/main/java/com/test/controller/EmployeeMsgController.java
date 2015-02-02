package com.test.controller;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.model.Employee;
import com.test.model.Employees;
import com.test.service.EmployeeService;

@Component
public class EmployeeMsgController {

	@Autowired
	public EmployeeService employeeService;
	
	public EmployeeMsgController() {
		System.out.println("In EmployeeMsgController default constructor");
	}
	
	
	public void processMessage(Employee employee, String type) {	
		System.out.println("In Process Message");
		try {
			if ("create".equals(type )) {
				createEmployee(employee);
			} else if ("update".equals(type)) {
				updateEmployee(employee);
			} else if ("delete".equals(type)) {
				deleteEmployee(employee.getEmployeeNumber());
			}
		} catch (SQLException e) {
			throw new EmployeeNotFoundException();
		}
	}
	public Employee getEmployeeById(Long employeeNumber){		
		try {
			return employeeService.findEmployeeById(employeeNumber);
		} catch (Exception e) {
			throw new EmployeeNotFoundException();
		}
	}

	public Employees getAllEmployees() throws SQLException{
		Employees employees= new Employees();
		employees.setEmployees(employeeService.getAllEmployees());
		return employees;	
	}

	public void deleteEmployee(Long employeeNumber) throws SQLException{
		employeeService.removeEmployee(employeeNumber);
	}

	public void createEmployee(Employee employee) throws SQLException{
		employeeService.createNewEmployee(employee);		
	}


	public void updateEmployee(Employee employee) throws SQLException{
		employeeService.updateEmployee(employee);
	}
	

}
