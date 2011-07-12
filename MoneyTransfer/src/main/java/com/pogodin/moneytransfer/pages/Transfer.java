package com.pogodin.moneytransfer.pages;

import org.apache.tapestry5.annotations.Property;

import com.pogodin.moneytransfer.bankelements.BankAccount;

public class Transfer {
	
	@Property
	private BankAccount incoming;
	
	@Property
	private BankAccount outgoing;
	
}
