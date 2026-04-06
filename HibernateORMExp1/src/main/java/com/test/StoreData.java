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
		
		Employee emp = new Employee();
		
		emp.setEmp_name("Sky");
		emp.setEmp_company("BCC");
		emp.setEmp_city("Mumbai");
		
		session.persist(emp);
		
		t.commit();
		
		Employee obj = session.find(Employee.class, 102);
		
		System.out.println(obj.getId()+" "+obj.getEmp_name()+" "+obj.getEmp_company()+" "+obj.getEmp_city());
		obj.setEmp_name("Hardik");
		obj.setEmp_company("PWC");
		obj.setEmp_city("Bangalore");
		
		//session.persist(obj);
		
		//session.remove(obj);
		
		
		System.out.println("Done.");
		
		session.close();
		
	}
}
