package com.test.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Employee findEmployeeByNumber(Long employeeNumber)  {
		String query="select a.employeeNumber,a.name,a.city as city ,a.country as country,a.emailaddress from employee a where a.employeeNumber=? ";		
		Employee employee=jdbcTemplate.queryForObject(query,new Object[]{employeeNumber}, new BeanPropertyRowMapper<Employee>(Employee.class));
		return employee;
	}

	public List<Employee> findAllEmployees()  {
		String query="select a.employeeNumber,a.name,a.city as city,a.country as country,a.emailaddress from employee a  ";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Employee>(Employee.class));
		
	
	}

	public void save(Employee employee)  {
		String query="insert into employee(name,city,country,emailaddress) values(?,?,?,?)";
		jdbcTemplate.update(query,employee.getName(),employee.getCity(),employee.getCountry(),
				employee.getEmailAddress());
		
		System.out.println("Account saved");	
	}

	public void update(Employee employee) {
		String query="update employee set name=?,city=?,country=?,emailaddress=? where employeeNumber=?";
		jdbcTemplate.update(query,employee.getName(),employee.getCity(),employee.getCountry(),
				employee.getEmailAddress(),employee.getEmployeeNumber());
		
		System.out.println("Account updated");
	}

	public void delete(Long employeeNumber)  {
		String query="delete from  employee  where  employeeNumber=?";
		jdbcTemplate.update(query,employeeNumber);
		System.out.println("Account Deleted");
	
	}

	public String findNameByEmployeeNumber(Long employeeNumber) { 
		String sql="select name from Account where employeeNumber= ?";
		return jdbcTemplate.queryForObject(sql, String.class);
	}

	public Map<String, Object> getEmployeeByNumberAsMap(Long employeeNumber) {
		String query="select a.employeeNumber,a.name,a.city as 'address.city',a.country as 'address.country',a.emailaddress from employee a where a.employeeNumber=? ";		
		
		return jdbcTemplate.queryForMap(query, employeeNumber);
	}

	public List<Map<String, Object>> getAllEmployeesAsMap() {
		String query="select a.employeeNumber,a.name,a.city as address.city,a.country as address.country,a.emailaddress from employee a  ";
		
		return jdbcTemplate.queryForList(query);
	}






}
