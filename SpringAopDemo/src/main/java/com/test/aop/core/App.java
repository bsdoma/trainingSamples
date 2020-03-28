package com.test.aop.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.aop.customer.dao.CustomerDAO;



public class App {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");

		CustomerDAO customer = (CustomerDAO) appContext.getBean("customerDao");
		customer.addCustomer();
		
		customer.addCustomerReturnValue();
		
	    customer.addCustomerThrowException();
		
		//customer.addCustomerAround("brahmi");

	}
}