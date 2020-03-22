package com.training.hibernate.associations.oneToOne;



import org.hibernate.Session;

import com.training.hibernate.HibernateUtil;
import com.training.hibernate.associations.oneToOne.sharedPrimaryKey.AccountEntity;
import com.training.hibernate.associations.oneToOne.sharedPrimaryKey.EmployeeEntity;

public class TestSharedPrimaryKey
{
	
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		AccountEntity account = new AccountEntity();
		account.setAccountNumber("123-345-65454");
		
		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");
		
		emp.setAccount(account);
		account.setEmployee(emp);
		//Save Employee
		session.save(emp);
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
