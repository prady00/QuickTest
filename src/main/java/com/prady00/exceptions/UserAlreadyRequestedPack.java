package com.prady00.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class UserAlreadyRequestedPack extends Exception {
	
	public UserAlreadyRequestedPack(String str) {
		super(str);
	}

}
