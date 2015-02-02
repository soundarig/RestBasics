package com.test.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.springframework.amqp.AmqpIOException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MethodInvoker;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.test.model.Employee;
import com.test.service.EmployeeService;

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
