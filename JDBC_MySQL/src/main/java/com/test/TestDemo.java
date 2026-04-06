package com.test;

import java.util.List;

public class TestDemo {
	
	public static void main(String[] args) {
		
		EmpDao edao = new EmpDao();
		
		Employee emp1 = new Employee();
		
		emp1.setId(3);
		emp1.setName("Surya Kumar");
		emp1.setCmp("BCC");
		emp1.setCity("Hyd");
		
		//edao.saveEmployee(emp1);
		
		edao.updateEmployee(emp1);
		
		System.out.println("Updated Employee Data.");
		
		List<Employee> data = edao.getAllEmployees();
		
		data.forEach(System.out::println);
		
	}
}
