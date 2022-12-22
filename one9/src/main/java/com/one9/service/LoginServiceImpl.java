package com.one9.service;


import com.one9.dao.CustomerDAO;
import com.one9.dao.SessionDAO;
import com.one9.exception.LoginException;
import com.one9.model.CurrentUserSession;
import com.one9.model.Customer;
import com.one9.model.LoginDTO;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDAO cDao;
	
	@Autowired
	private SessionDAO sDao;
	
	@Override
	public String logIntoAccount(LoginDTO dto)throws LoginException {
		Customer existingCustomer= cDao.findByMobileNumber(dto.getMobileNumber());
		if(existingCustomer == null) {
			throw new LoginException("Please Enter a valid mobile number");
		}

		CurrentUserSession currentUserSession = sDao.findByUserId(existingCustomer.getMobileNumber());

		if(currentUserSession!=null) {
			throw new LoginException("User already login with this userId");
		}

		if(existingCustomer.getMobileNumber().equals(dto.getMobileNumber()) && existingCustomer.getPassword().equals(dto.getPassword())) {
			String key= RandomString.make(6);
			CurrentUserSession newCurrentUserSession = new CurrentUserSession(existingCustomer.getMobileNumber(), key, LocalDateTime.now());
			sDao.save(newCurrentUserSession);
			return  newCurrentUserSession.toString();
		} else {
			throw new LoginException("Invalid mobile and Password");
		}

		/*
		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getCustomerId());
		if(validCustomerSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			String key= RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			sDao.save(currentUserSession);
			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		*/
	}

	@Override
	public String logOutFromAccount(String key)throws LoginException {
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
		}
		sDao.delete(validCustomerSession);
		return "Logged Out !";
	}

}
