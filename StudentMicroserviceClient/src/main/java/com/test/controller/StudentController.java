package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;
import com.test.repository.RemoteStudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private RemoteStudentRepository repository;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student std)
	{
		return repository.createStudent(std);
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student std)
	{
		
		return repository.updateStudentById(std, id);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id)
	{
		return repository.getStudentById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Student> deleteStudentById(@PathVariable int id)
	{
		return repository.deleteStudentById(id);
	}
	@GetMapping("/list")
	public List<Student> getALLStudents()
	{
		return repository.getAllStudents();
	}
}
