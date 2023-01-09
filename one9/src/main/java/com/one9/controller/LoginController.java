package com.one9.controller;
import com.one9.exception.LoginException;
import com.one9.model.LoginDTO;
import com.one9.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@Valid @RequestBody LoginDTO dto) throws LoginException {
		String result = customerLogin.logIntoAccountCustomer(dto);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logoutCustomer(@Valid @RequestParam String key) throws LoginException {
		String result = customerLogin.logOutFromAccountCustomer(key);
		return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
	}
}
