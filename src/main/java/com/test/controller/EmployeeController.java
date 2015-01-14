package com.test.controller;

import java.net.URI;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

import com.test.model.Employee;
import com.test.model.Employees;
import com.test.service.EmployeeService;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	@RequestMapping(value="/{employeeNumber}",
			produces={"application/json","application/xml"},method=RequestMethod.GET)
	public @ResponseBody Employee getEmployeeById(@PathVariable("employeeNumber") Long employeeNumber){		
		try {
			return employeeService.findEmployeeById(employeeNumber);
		} catch (Exception e) {
			throw new EmployeeNotFoundException();
		}
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody Employees getAllEmployees() throws SQLException{
		Employees employees= new Employees();
		employees.setEmployees(employeeService.getAllEmployees());
		return employees;	
	}

	@RequestMapping(value="/{employeeNumber}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteEmployee(@PathVariable("employeeNumber") Long employeeNumber) throws SQLException{
		employeeService.removeEmployee(employeeNumber);
	}

	@RequestMapping(value="/", 
			consumes={"application/xml","application/json"}, method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public HttpEntity<String> createEmployee(@Value("#{request.requestURL}") String originalUrl, @RequestBody Employee employee) throws SQLException{
		employeeService.createNewEmployee(employee);
		String locationUrl=originalUrl+"/"+"{employeeNumber}";

		URI uri=new UriTemplate(locationUrl).expand(employee.getEmployeeNumber());
		System.out.println(uri);
		HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.setLocation(uri);

		return new HttpEntity<String>(httpHeaders);
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)	
	public void updateEmployee(@RequestBody Employee employee) throws SQLException{
			employeeService.updateEmployee(employee);
	}

}
