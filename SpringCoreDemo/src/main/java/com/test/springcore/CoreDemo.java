package com.test.springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class CoreDemo {

	public static void main(String[] args) {
//		Employee emp = new Employee();
//		emp.setId(101);
//		emp.setName("Test");
//		emp.setSalary(20000);
//		
//		System.out.println("Employee -->"+ emp);
		
		//1.Add Spring Core container libraries
		//2.Create xml mapping for bean class
		//3.Use Spring IOC Container .i.e Bean Factory or Application Context.
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee e = context.getBean("employee1",Employee.class);
		//Employee e2 = context.getBean("employee2",Employee.class);
		//System.out.println("Employee2 from Context -->"+ e2);
		System.out.println("Employee from Context -->"+ e);
		ClassPathXmlApplicationContext cxt = (ClassPathXmlApplicationContext)context;
		cxt.close();
		
//		BeanFactory beanFactory = new XmlBeanFactory (new ClassPathResource("beans.xml"));
//		Employee e1 = (Employee) beanFactory.getBean("employee1");
//		//Employee e2 =  beanFactory.getBean("employee2",Employee.class);
//		
//		System.out.println("Employee1 from beanFactory-->"+e1);
//		//System.out.println("Employee2 from beanFactory-->"+e2);
		
		
		

	}

}
