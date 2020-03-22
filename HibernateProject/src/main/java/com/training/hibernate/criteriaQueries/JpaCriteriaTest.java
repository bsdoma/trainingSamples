package com.training.hibernate.criteriaQueries;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaCriteriaTest {
	public static void main(String[] args) {
		EntityManager em = PersistenceManager._INSTANCE.getEntityManager();
		try {
			em.getTransaction().begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<UserDetails> from = criteriaQuery.from(UserDetails.class);
			// select all records
			System.out.println("Select all records");
			System.out.println("------------------");
			System.out.println();
			CriteriaQuery<Object> select = criteriaQuery.select(from);
			TypedQuery<Object> typedQuery = em.createQuery(select);
			List<Object> resultlist = typedQuery.getResultList();
			for (Object o : resultlist) {
				UserDetails u = (UserDetails) o;
				System.out.println("ID : " + u.getId() + " First Name : " + u.getFirstName() + " Last Name : "
						+ u.getLastName() + " Email : " + u.getEmail() + " DOB : " + u.getDob());
			}
			// Ordering the records
			System.out.println();
			System.out.println("Select all records in ascending order");
			System.out.println("-------------------------------------");
			System.out.println();
			CriteriaQuery<Object> select1 = criteriaQuery.select(from);
			select1.orderBy(criteriaBuilder.asc(from.get("firstName")));
			TypedQuery<Object> typedQuery1 = em.createQuery(select);
			List<Object> resultlist1 = typedQuery1.getResultList();
			for (Object o : resultlist1) {
				UserDetails u = (UserDetails) o;
				System.out.println("ID : " + u.getId() + " First Name : " + u.getFirstName() + " Last Name : "
						+ u.getLastName() + " Email : " + u.getEmail() + " DOB : " + u.getDob());
			}
			em.getTransaction().commit();
		} catch (JpaException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			PersistenceManager._INSTANCE.close();
		}
		// update user for id 11
		try {
			UserDetails user = new UserDetails();
			user.setId(13);
			user.setFirstName("Liton");
			user.setLastName("Sarkar");
			user.setEmail("liton.sarkar@email.com");
			user.setDob("14-07-1990");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
