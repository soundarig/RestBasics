package com.test.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee",namespace="http://test.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements Serializable{
	
	private Long employeeNumber;
	private String name;
	private String city;
	private String country;
	private String emailAddress;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

	public Employee(Long employeeNumber, String name, 
		  String emailAddress,String city,String country) {
		super();
		this.employeeNumber = employeeNumber;
		this.name = name;
		this.emailAddress = emailAddress;
		this.city=city;
		this.country=country;
	
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name="+name+ " employeeNumber ="+employeeNumber+" city"+city+" Country= "+country;
	}

		public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	
	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	
	

}
