package com.test.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.handler.annotation.SendTo;

import com.test.model.Employee;

public class MessageSender {
	@Autowired
	private RabbitTemplate amqpTemplate;
	@SendTo("myqueue")
	public void send() { 
//		Employee employee = new Employee(Long.valueOf("4"),"test","test@abc.com","city","country");
		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml", "infrastructure-config.xml"); 
		amqpTemplate = (RabbitTemplate)context.getBean("amqpTemplate");
		amqpTemplate.setRoutingKey("myqueue");
		amqpTemplate.convertAndSend("hi"); 
		System.out.println("Message  sent."); 
	} 
	
	public void receive() { 
//		Employee employee = new Employee(Long.valueOf("4"),"test","test@abc.com","city","country");
		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml", "infrastructure-config.xml"); 
		amqpTemplate = (RabbitTemplate)context.getBean("amqpTemplate");
		amqpTemplate.setRoutingKey("myqueue");
		Message msg = amqpTemplate.receive("myqueue"); 
		System.out.println("Message  Received." + msg); 
	} 
	public static void main(String[] args) { 
		MessageSender sender = new MessageSender();
		sender.send();
		sender.receive(); 
	} 
}
