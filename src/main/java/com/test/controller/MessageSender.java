package com.test.controller;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.model.Employee;

public class MessageSender {
	@Autowired
	private RabbitTemplate amqpTemplate;

	public void send() {
		Employee employee = new Employee(Long.valueOf("4"), "trial",
				"trial@abc.com", "city", "country");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-config.xml", "infrastructure-config.xml");
		amqpTemplate = (RabbitTemplate) context.getBean("amqpTemplate");
		amqpTemplate.convertAndSend("myqueue", employee,
				new org.springframework.amqp.core.MessagePostProcessor() {

					public Message postProcessMessage(Message message)
							throws AmqpException {
						message.getMessageProperties().setHeader("type",
								"create");
						return message;
					}
				});

		System.out.println("Message  sent.");
	}

	public void receive() {
		// Employee employee = new
		// Employee(Long.valueOf("4"),"test","test@abc.com","city","country");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-config.xml", "infrastructure-config.xml");
		amqpTemplate = (RabbitTemplate) context.getBean("amqpTemplate");
		amqpTemplate.setRoutingKey("myqueue");
		Message msg = amqpTemplate.receive("myqueue");
		System.out.println("Message  Received." + msg);
	}

	public static void main(String[] args) {
		MessageSender sender = new MessageSender();
		sender.send();
		// sender.receive();
	}
}
