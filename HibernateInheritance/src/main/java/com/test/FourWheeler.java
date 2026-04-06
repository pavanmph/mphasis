package com.test;
 
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
 
@Entity
//@Table(name="four_wheeler")
@DiscriminatorValue("Car")
public class FourWheeler extends Vehcle{
 
	private String steeringWheel;
	public String getSteeringWheel() {
		return steeringWheel;
	}
 
	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel; 
	}s
}