package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.service.IStudentService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> listStudents(){
		return new ResponseEntity<List<Student>>(service.listStudents(),HttpStatus.OK);
	}
	
	@PostMapping
	public Student addstudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
		return service.updateStudent(student, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return service.getStudentById(id);
	}

}
