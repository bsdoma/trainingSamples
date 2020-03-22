package com.training.hibernate.associations.oneToMany;

import com.training.hibernate.HibernateUtil;
import com.training.hibernate.associations.oneToMany.foreignKeyAsso.AccountEntity;
import com.training.hibernate.associations.oneToMany.foreignKeyAsso.EmployeeEntity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class TestForeignKeyAssociation
{
	
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		AccountEntity account1 = new AccountEntity();
		account1.setAccountNumber("Account detail 1");
		
		AccountEntity account2 = new AccountEntity();
		account2.setAccountNumber("Account detail 2");
		
		
		//Add new Employee object
		EmployeeEntity firstEmployee = new EmployeeEntity();
		firstEmployee.setEmail("demo-user-first@mail.com");
		firstEmployee.setFirstName("demo-one");
		firstEmployee.setLastName("user-one");
		
		
		Set<AccountEntity> accountsOfFirstEmployee = new HashSet<AccountEntity>();
		accountsOfFirstEmployee.add(account1);
		accountsOfFirstEmployee.add(account2);
		
		
		firstEmployee.setAccounts(accountsOfFirstEmployee);
		//Save Employee
		session.save(firstEmployee);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		
		
	}
	
	

}
