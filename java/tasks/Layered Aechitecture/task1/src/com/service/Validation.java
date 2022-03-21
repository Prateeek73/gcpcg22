package com.service;

import com.exceptions.InvalidBalanceException;
import com.exceptions.InvalidNameException;

public class Validation {
	public static void validateName(String name) throws InvalidNameException {
		if(name.length() <2 && name.length()>10)
			throw new InvalidNameException("Invali Name");
	}
	public static void validateBalance(double balance) throws InvalidBalanceException {
		if(balance<3000)
			throw new InvalidBalanceException("Invalid Balance");
	}
}
