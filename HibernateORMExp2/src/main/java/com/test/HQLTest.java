package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

public class HQLTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		String hql = "select o.o_name, o_quantity, o_price from Order o";
		
		Query<Order> q = session.createQuery(hql, Order.class);
		
		List<Order> list = q.getResultList();
		
		list.forEach(dt -> System.out.println(
				dt.getO_name()+" "+
				dt.getO_quantity()+" "+
				dt.getO_price()));

	}

}
