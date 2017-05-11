package com.jyoti.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jyoti.hibernate.model.Branch;
import com.jyoti.hibernate.model.Customer;
import com.jyoti.hibernate.util.HibernateUtil;


//Saving many-to-many where Branch is primary
public class HibernateManyToManyTest {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer();
		customer1.setName("Sonu");
		customer1.setAddress("Delhi");
		
		Customer customer2 = new Customer();
		customer2.setName("Naveen");
		customer2.setAddress("Varansi");
		
		
		Set<Customer> customers = new HashSet<Customer>();
		customers.add(customer1); 
		customers.add(customer2); 
		
		Branch branch = new Branch();
		branch.setCustomers(customers);
		branch.setAddress("Kolkata");
		branch.setEmail("kolkata@bank");
		
		Branch branch1 = new Branch();
		Set<Customer> customers1 = new HashSet<Customer>();
		customers1.add(customer1);
		branch1.setCustomers(customers1);
		branch1.setAddress("Noida");
		branch1.setEmail("noida@bank");
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(branch);
		session.save(branch1);
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


