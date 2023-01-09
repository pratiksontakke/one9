package com.one9.service;


import com.one9.exception.LoginException;
import com.one9.model.LoginDTO;

public interface LoginService {
	
	public String logIntoAccountCustomer(LoginDTO dto)throws LoginException;

	public String logOutFromAccountCustomer(String key)throws LoginException;

	public boolean isLoginCustomer(String key) throws LoginException;

	public String logIntoAccountEmployee(LoginDTO dto)throws LoginException;

	public String logOutFromAccountEmployee(String key)throws LoginException;

	public boolean isLoginEmployee(String key) throws LoginException;

}
