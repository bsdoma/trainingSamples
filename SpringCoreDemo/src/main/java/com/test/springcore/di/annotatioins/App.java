package com.test.springcore.di.annotatioins;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans1.xml");

		Contact contact = (Contact) context.getBean("ContactBean");
		System.out.println(contact);
	}
}