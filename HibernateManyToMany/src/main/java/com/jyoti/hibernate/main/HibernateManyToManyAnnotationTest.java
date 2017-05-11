package com.jyoti.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jyoti.hibernate.model.BranchAnno;
import com.jyoti.hibernate.model.CustomerAnno;
import com.jyoti.hibernate.util.HibernateAnnotationUtil;

public class HibernateManyToManyAnnotationTest {

	public static void main(String[] args) {
		
		
		
		CustomerAnno custAnno1 = new CustomerAnno();
		custAnno1.setName("Ankur");
		custAnno1.setAddress("Allahabad");
		
		CustomerAnno custAnno2 = new CustomerAnno();
		custAnno2.setName("Aditya");
		custAnno2.setAddress("Ranchi");
	
		BranchAnno branchAnno = new BranchAnno();
		branchAnno.setAddress("Amritsar");
		branchAnno.setEmail("amritsar@bank");
		
		Set<CustomerAnno> customerAnnos = new HashSet<CustomerAnno>();
		customerAnnos.add(custAnno1);
		customerAnnos.add(custAnno2);
		
		branchAnno.setCustomerAnno(customerAnnos);
		
		
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(branchAnno);
		System.out.println("Before committing transaction");
		tx.commit();
		sessionFactory.close();
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
	}
	

}
