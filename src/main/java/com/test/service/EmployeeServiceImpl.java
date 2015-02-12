package com.test.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.test.model.Employee;
import com.test.repository.EmployeeRepository;
import com.test.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl() {
		System.out.println("In EmployeeServiceImpl default constructor");
	}

	public void createNewEmployee(Employee employee) throws SQLException {
		employeeRepository.save(employee);

	}

	// TODO: Check update
	public void updateEmployee(Employee employee) throws SQLException {
		employeeRepository.save(employee);

	}

	public void removeEmployee(Long employeeNumber) throws SQLException {
		employeeRepository.delete(employeeNumber);
	}

	public List<Employee> getAllEmployees() throws SQLException {
		System.out.println("EmployeeServiceImpl.getAllEmployees()");
		Iterable<Employee> iterable = employeeRepository.findAll();
		if(iterable!=null){
			Iterator<Employee> iterator = iterable.iterator();
			List<Employee> employees = new ArrayList<Employee>();
			for (Employee employee : iterable) {
				employees.add(employee);
			}
			return employees;
		}
		//return employeeRepository.findAllEmployees();
		return null;
	}

	public Employee findEmployeeById(Long employeeNumber) {
		return employeeRepository.findOne(employeeNumber);
	}

	public CrudRepository<Employee, Long> getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeCassandraRepository) {
		this.employeeRepository = employeeCassandraRepository;
	}

}
