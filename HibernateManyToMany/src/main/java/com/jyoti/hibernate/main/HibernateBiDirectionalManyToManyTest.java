package com.jyoti.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jyoti.hibernate.model.Branch;
import com.jyoti.hibernate.model.Customer;
import com.jyoti.hibernate.util.HibernateUtil;

//Saving many-to-many where Customer is primary
public class HibernateBiDirectionalManyToManyTest {

	public static void main(String[] args) {
		
		
		Customer customer1 = new Customer();
		customer1.setName("Anand");
		customer1.setAddress("Bihar");
		
		Customer customer2 = new Customer();
		customer2.setName("Rohit");
		customer2.setAddress("Hydrabad");
		
		
		Branch branch = new Branch();
		branch.setAddress("Hydrabad");
		branch.setEmail("hydrabad@bank");
		
		Branch branch1 = new Branch();
		branch1.setAddress("Bangalore");
		branch1.setEmail("bangalore@bank");
		
		Set<Branch> branches = new HashSet<Branch>();
		branches.add(branch);
		branches.add(branch1);
		
		Set<Branch> branches1 = new HashSet<Branch>();
		branches1.add(branch);
		
		customer1.setBranches(branches1);
		customer2.setBranches(branches);
		
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(customer1);
		session.save(customer2);
		tx.commit();
		sessionFactory.close();
		
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
		
	}
		

	}


