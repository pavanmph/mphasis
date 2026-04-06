package com.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String cus_name;
	
	private String cus_company;
	
	private String cus_city;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_company() {
		return cus_company;
	}

	public void setCus_company(String cus_company) {
		this.cus_company = cus_company;
	}

	public String getCus_city() {
		return cus_city;
	}

	public void setCus_city(String cus_city) {
		this.cus_city = cus_city;
	}

	
	
	

}
