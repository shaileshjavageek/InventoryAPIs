package com.roberthalf.webservice.inventory.InventoryAPIs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InentoryNotFoundException extends RuntimeException{
	
	public InentoryNotFoundException(String message) {
		super(message);
	}

}
