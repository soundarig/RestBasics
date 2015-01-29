package com.test.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.test.controller.EmployeeNotFoundException;
import com.test.model.Employee;
import com.test.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl() {
		System.out.println("In EmployeeServiceImpl default constructor");
	}
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		System.out.println("In EmployeeServiceImpl parameterised constructor");
	}

	public void createNewEmployee(Employee employee) throws SQLException {
		employeeRepository.save(employee);
		
	}
	
	public void updateEmployee(Employee employee) throws SQLException {
		employeeRepository.update(employee);
		
	}
	
	public void removeEmployee(Long employeeNumber) throws SQLException {
		employeeRepository.delete(employeeNumber);		
	}

	
	
	public List<Employee> getAllEmployees() throws SQLException {
		System.out.println("EmployeeServiceImpl.getAllEmployees()");
		return employeeRepository.findAllEmployees();
	}
	
	public Employee findEmployeeById(Long employeeNumber) {
		
		return employeeRepository.findEmployeeByNumber(employeeNumber);
	}
	
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}


	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

}
