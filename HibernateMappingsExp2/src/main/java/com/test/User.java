package com.test;
 
import java.util.List;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
 
@Entity
@Table(name="users")
public class User {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String u_name;
 
	@OneToMany(cascade=CascadeType.ALL)
	private List<Order> order;
 
	public List<Order> getOrder() {
		return order;
	}
 
	public void setOrder(List<Order> order) {
		this.order = order;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getU_name() {
		return u_name;
	}
 
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	
}