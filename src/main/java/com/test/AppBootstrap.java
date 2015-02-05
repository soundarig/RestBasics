package com.test;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.test.model.Employee;
import com.test.service.EmployeeService;

@Component
public class AppBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private EmployeeService empService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent ctxtRefreshedEvnt) {
		Employee emp = new Employee(new Long(15007), "Raja", "raja@emc.com",
				"Bengaluru", "India");
		try {
			empService.createNewEmployee(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
