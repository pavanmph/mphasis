package com.test;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
//@Table(name = "student")
//@PrimaryKeyJoinColumn(name = "ID")
@DiscriminatorValue("student")
public class Student extends College
{
	@Column(name = "std_type")
	private String type;
	
	@Column(name = "std_branch")
	private String s_branch;
	
	public Student()
	{
		
	}
	
	public Student(int id, String c_name, String s_type, String s_branch )
	{
		super(id,c_name);
		
		this.type = s_type;
		
		this.s_branch = s_branch;
	}

	public String getS_type() {
		return type;
	}

	public void setS_type(String s_type) {
		this.type = s_type;
	}

	public String getS_branch() {
		return s_branch;
	}

	public void setS_branch(String s_branch) {
		this.s_branch = s_branch;
	}

	@Override
	public String toString() {
		return "Student [s_type=" + type + ", s_branch=" + s_branch + "]";
	}
}
