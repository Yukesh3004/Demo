package com.project.exceptions;

public class StudentAlreadyExitsException extends RuntimeException{
	
	public StudentAlreadyExitsException(String message) {
		super(message);
	}

}
