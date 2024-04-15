package com.project.service;

import java.util.List;

import com.project.model.Student;

public interface IStudentService {
	
	public Student addStudent(Student student);
	
	public List<Student> listStudents();
	
	public Student updateStudent(Student student, Long id);
	
	public Student getStudentById(Long id);
	
	public void deleteStudentById(Long id);

}
