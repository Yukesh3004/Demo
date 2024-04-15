package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	// The optional is represent the Student is may or maynot be present.
	
	Optional<Student> findByEmail(String email);

}
