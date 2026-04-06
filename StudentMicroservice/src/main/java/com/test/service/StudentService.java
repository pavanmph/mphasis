package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Student;
import com.test.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public Student addStudent(Student obj)
	{
		return repository.save(obj);
	}
	
	public Student getStudentById(int id)
	{
		return repository.findById(id).get();
	}
	
	public Student updateStudent(Student obj)
	{
		return repository.save(obj);
	}
	
	public List<Student> deleteStudentById(int id)
	{
		repository.deleteById(id);
		
		return repository.findAll();
	}
	
	public List<Student> listAllStudents()
	{
		return repository.findAll();
	}
}
