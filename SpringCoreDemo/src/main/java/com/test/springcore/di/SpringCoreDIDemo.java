package com.test.springcore.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreDIDemo {
	public static void main(String[] a) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer customer = context.getBean("customer",Customer.class);
		System.out.println("Customer-->"+ customer);
	}

}
