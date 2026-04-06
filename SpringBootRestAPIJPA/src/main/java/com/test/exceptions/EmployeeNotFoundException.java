package com.test.exceptions;

public class EmployeeNotFoundException extends RuntimeException
{

	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public EmployeeNotFoundException(String msg)
	{
		super(msg);
		
		this.msg = msg;
	}

}
