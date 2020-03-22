package com.training.hibernate.associations.oneToOne;



import org.hibernate.Session;

import com.training.hibernate.HibernateUtil;
import com.training.hibernate.associations.oneToOne.joinTable.OneAccountEntity;
import com.training.hibernate.associations.oneToOne.joinTable.OneEmployeeEntity;

public class TestJoinTable
{
	
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		OneAccountEntity account = new OneAccountEntity();
		account.setAccountNumber("123-345-65454");
		
		//Add new Employee object
		OneEmployeeEntity emp = new OneEmployeeEntity();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");
		
		emp.setAccount(account);
		//Save Employee
		session.save(emp);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
