package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestEmp {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnConfig.class);
		
		Employee emp1 = ctx.getBean("getSetterObj", Employee.class);
		
		emp1.setId(203);
		emp1.setName("SKY");
		emp1.setCmp("IPL");
		emp1.setSalary(3423);
		
		System.out.println(emp1);
		
		Employee emp2 = ctx.getBean("getConstObj", Employee.class);
		
		System.out.println(emp2);
	}
}
