package com.one9.service;


import com.one9.exception.LoginException;
import com.one9.model.LoginDTO;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
