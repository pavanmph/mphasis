package com.test;
 
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
 
@Entity
//@Table(name="two_wheeler")
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehcle{
	private String steeringHandle;
 
	public String getSteeringHandle() {
		return steeringHandle;
	}
 
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
 
}
 
 
 