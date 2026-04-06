package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Customer cus = new Customer();
		
		cus.setCus_name("Sky");
		cus.setCus_company("BCC");
		cus.setCus_city("Mumbai");
		
		session.persist(cus);
		
		t.commit();
		
		Customer obj = session.find(Customer.class, 2);
		
		System.out.println(obj.getId()+" "+obj.getCus_name()+" "+obj.getCus_company()+" "+obj.getCus_city());
		obj.setCus_name("Hardik");
		obj.setCus_company("PWC");
		obj.setCus_city("Bangalore");
		
		//session.persist(obj);
		
		//session.remove(obj);
		
		
		System.out.println("Done.");
		
		session.close();
		
	}
}
