package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Student;
import com.project.repository.StudentRepository;
import com.project.exceptions.StudentAlreadyExitsException;
import com.project.exceptions.StudentNotFoundException;

@Service
public class StudentServiceIMPL implements IStudentService{
	
	@Autowired
	private StudentRepository repo;
	

	@Override
	public Student addStudent(Student student) {
		if(studentAlreadyExits(student.getEmail())) {
			throw new StudentAlreadyExitsException(student.getEmail()+" already exits!");
		}
		return repo.save(student);
	}

	@Override
	public List<Student> listStudents() {
		return repo.findAll();
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		return repo.findById(id).map(st -> {
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setDepartment(student.getDepartment());
			return repo.save(st);
		}).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found."));
	}

	@Override
	public Student getStudentById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found."));
	}

	@Override
	public void deleteStudentById(Long id) {
		
		if(!repo.existsById(id)) {
			throw new StudentNotFoundException("Sorry, this student could not be found.");
		}
		repo.deleteById(id);
		
	}

	public boolean studentAlreadyExits(String email) {
		
		// isPresent method returns true if the value is present otherwise it will return false.
		return repo.findByEmail(email).isPresent();
		
	}
}
