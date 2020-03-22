package com.training.hibernate.orphanremoval;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.hibernate.HibernateUtil;

public class TestOrphanRemovalCascade
{
   public static void main(String[] args)
   {
      setupTestData();
       
      Session sessionOne = HibernateUtil.getSessionFactory().openSession();
      org.hibernate.Transaction tx = sessionOne.beginTransaction();
       
      //Load the employee in another session
      OrphanEmployeeEntity employee = (OrphanEmployeeEntity) sessionOne.load(OrphanEmployeeEntity.class, 1);
      //Verify there are 3 accounts
      System.out.println("Step 1 : " + employee.getAccounts().size());
       
      //Remove an account from first position of collection
    
      employee.getAccounts().remove(employee.getAccounts().iterator().next());
       
      //Verify there are 2 accounts in collection
      System.out.println("Step 2 : " + employee.getAccounts().size());
       
      tx.commit();
      sessionOne.close();
       
      //In another session check the actual data in database
      Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
      sessionTwo.beginTransaction();
       
      OrphanEmployeeEntity employee1 = (OrphanEmployeeEntity) sessionTwo.load(OrphanEmployeeEntity.class, 1);
      //Verify there are 2 accounts now associated with Employee
      System.out.println("Step 3 : " + employee1.getAccounts().size());
       
      //Verify there are 2 accounts in Account table
      Query query = sessionTwo.createQuery("from Account a");
      @SuppressWarnings("unchecked")
      List<OrphanAccountEntity> accounts = query.list();
      System.out.println("Step 4 : " + accounts.size());
       
      sessionTwo.close();
       
      HibernateUtil.shutdown();
   }  
    
   private static void setupTestData(){
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
       
      //Create Employee
      OrphanEmployeeEntity emp = new OrphanEmployeeEntity();
      emp.setEmployeeId(1);
      emp.setFirstName("Lokesh");
      emp.setLastName("Gupta");
      session.save(emp);
       
      //Create Account 1
      OrphanAccountEntity acc1 = new OrphanAccountEntity();
      acc1.setAccountId(1);
      acc1.setAccountNumber("11111111");
      acc1.setOrphanEmployee(emp);
      session.save(acc1);
       
      //Create Account 2
      OrphanAccountEntity acc2 = new OrphanAccountEntity();
      acc2.setAccountId(2);
      acc2.setAccountNumber("2222222");
      acc2.setOrphanEmployee(emp);
      session.save(acc2);
       
      //Create Account 3
      OrphanAccountEntity acc3 = new OrphanAccountEntity();
      acc3.setAccountId(3);
      acc3.setAccountNumber("33333333");
      acc3.setOrphanEmployee(emp);
      session.save(acc3);
             
      session.getTransaction().commit();
      session.close();
   }
}
