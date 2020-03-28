package com.test.springcore.di.annotatioins.autowiring.byType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowire {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = 
		    	  new ClassPathXmlApplicationContext("com/test/springcore/di/annotatioins/autowiring/byType/application-context.xml");
		 
		    	EmployeeBean employee = (EmployeeBean)context.getBean("employee");
		    	System.out.println(employee.getFullName());
		    	System.out.println(employee.getDepartmentBean().getName());
	}
}
