package com.test;

import java.util.List;

public class OrderDemo {
	
	public static void main(String[] args) {
		
		OrderDao odao = new OrderDao();
		
		Order obj = new Order();
		obj.setId(1);
		obj.setO_name("Pen");
		obj.setO_quantity(50);
		obj.setO_price(500);
		
		//odao.saveOrder(obj);
		
		List<Order> list = odao.listAllOrders();
		
		list.forEach(dt -> System.out.println(dt.getId()+" "+
											dt.getO_name()+" "+
											dt.getO_quantity()+" "+
											dt.getO_price()));
		
		System.out.println("Done.");
	}

}
