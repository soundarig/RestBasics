package com.test.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="allemployees",namespace="http://test.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
	
	@XmlElementWrapper(name="employees")
	@XmlElement(name="employee")
	
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	

}
