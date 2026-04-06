package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;
import com.test.exceptions.EmployeeNotFoundException;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee/v1/api")
@Tag(name = "EMPLOYE CRUD OPERATIONS")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping("/create")
	@Operation(summary = "CREATE EMPLOYEE")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp)
	{
		Employee eobj = service.saveEmployee(emp);
		
		if(eobj != null)
		{
			return new ResponseEntity<>(eobj, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>(eobj, HttpStatus.BAD_REQUEST); 
		}
	}
	
	@GetMapping("/list")
	@Operation(summary = "Listing all employees")
	public ResponseEntity<List<Employee>> listAllEmployees()
	{
		List<Employee> list = service.getAllEmployees();
		
		if(list.size() > 0)
		{
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	@Operation(summary = "update employee by id")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp)
	{
		emp.setId(id);
		
		Employee eobj = service.updateEmployee(emp);
		
		if(eobj != null)
		{
			return new ResponseEntity<>(eobj,HttpStatus.ACCEPTED);
		}
		else
		{
			//throw new EmployeeNotFoundException("NO_CONTENT_FOR_GIVEN_REQUEST");
			
			return new ResponseEntity<>(eobj, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "get employee by id")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id)
	{
		Optional<Employee> eobj = service.getEmployeeById(id);
		
		if(eobj != null)
		{
			return new ResponseEntity<>(eobj,HttpStatus.OK);
		}
		else
		{
			 //throw (new EmployeeNotFoundException("NO_CONTENT_FOR_GIVEN_REQUEST"));
			return new ResponseEntity<>(eobj, HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	@GetMapping("/{id}")
	@Operation(summary = "get employee by id")
	public Employee getEmployeeById(@PathVariable int id)
	{
		Employee emp = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("NO_CONTENT_FOR_GIVEN_REQUEST"));
		
		return emp;
	}
	*/
	
	@DeleteMapping("/{id}")
	@Operation(summary = "delete employee by id")
	public ResponseEntity<List<Employee>> deleteEmployeeById(@PathVariable int id)
	{
		List<Employee> list = service.deleteEmployeeById(id);
		
		if(list.size() > 0)
		{
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else
		{
			//throw new EmployeeNotFoundException("NO_CONTENT_FOR_GIVEN_REQUEST");
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/byname/{name}")
	@Operation(summary = "get employee by name")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name)
	{
		
		List<Employee> eobj = repository.getEmployeesByName(name);
		
		
		if(eobj.size() > 0)
		{
			return new ResponseEntity<>(eobj,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(eobj, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/bycmp/{company}")
	@Operation(summary = "get employee by name")
	public ResponseEntity<List<Employee>> getEmployeeByCompany(@PathVariable String company)
	{
		
		List<Employee> list = repository.getEmployeesByCompany(company);
		
		
		if(list.size() > 0)
		{
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/emplist/asc")
	@Operation(summary = "eployees by asc order by name")
	public ResponseEntity<List<Employee>> getEmployeesByNameASC()
	{
		List<Employee> list = repository.getEmployeesByNameASC();
		
		
		if(list.size() > 0)
		{
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
}
