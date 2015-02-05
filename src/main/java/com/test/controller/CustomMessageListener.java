package com.test.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.Employee;

public class CustomMessageListener implements MessageListener {
	@Autowired
	public EmployeeMsgController employeeMsgController;
	
	@Autowired
	public SerializerMessageConverter serializerMessageConverter;
	
	public void onMessage(Message message) {		
		Employee employee = (Employee) serializerMessageConverter.fromMessage(message);
		String type = (String) message.getMessageProperties().getHeaders().get("type");
		employeeMsgController.processMessage(employee, type);
	}
}
