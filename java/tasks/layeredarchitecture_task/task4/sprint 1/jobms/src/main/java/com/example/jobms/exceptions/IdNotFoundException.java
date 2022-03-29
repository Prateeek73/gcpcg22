package com.example.jobms.exceptions;

import com.example.jobms.entity.Job;

public class IdNotFoundException extends Exception {
	public IdNotFoundException(String txt){
		super(txt);
	}
}
