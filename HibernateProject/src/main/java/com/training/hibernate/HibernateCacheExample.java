package com.training.hibernate;	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;

import com.training.hibernate.model.Student;

	

	public class HibernateCacheExample {

		public static void main(String[] args) throws InterruptedException {
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			//Get employee with id=1
			Student student = (Student) session.load(Student.class, new Integer(1));
			printData(student,1);
			
			//waiting for sometime to change the data in backend
			Thread.sleep(10000);
			
			//Fetch same data again, check logs that no query fired
			Student student1 = (Student) session.load(Student.class, new Integer(1));
			printData(student1,2);
			
			//Create new session
			Session newSession = sessionFactory.openSession();
			//Get employee with id=1, notice the logs for query
			Student student2 = (Student) newSession.load(Student.class, new Integer(1));
			printData(student2,3);
			
			//START: evict example to remove specific object from hibernate first level cache
			//Get employee with id=2, first time hence query in logs
			Student student3 = (Student) session.load(Student.class, new Integer(2));
			printData(student3,4);
			
			//evict the employee object with id=1
			session.evict(student);
			System.out.println("Session Contains Employee with id=1?"+session.contains(student));

			//since object is removed from first level cache, you will see query in logs
			Student student4 = (Student) session.load(Student.class, new Integer(1));
			printData(student4,5);
			
			//this object is still present, so you won't see query in logs
			Student student5 = (Student) session.load(Student.class, new Integer(2));
			printData(student5,6);
			//END: evict example
			
			//START: clear example to remove everything from first level cache
			session.clear();
			Student student6 = (Student) session.load(Student.class, new Integer(1));
			printData(student6,7);
			Student student7 = (Student) session.load(Student.class, new Integer(2));
			printData(student7,8);
			
			System.out.println("Session Contains Employee with id=2?"+session.contains(student7));
			
			tx.commit();
			sessionFactory.close();
		}

		private static void printData(Student student, int count) {
			System.out.println(count+":: FirstName="+student.getFirstName()+", LastName="+student.getLastName());
		}



}
