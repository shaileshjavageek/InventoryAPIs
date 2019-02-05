package com.roberthalf.webservice.inventory.InventoryAPIs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class InentoryBadArgumentFoundException extends RuntimeException{
	
	public  InentoryBadArgumentFoundException(String message) {
		super(message);
	}

}
