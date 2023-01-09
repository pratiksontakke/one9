package com.one9.service;


import com.one9.dao.CustomerDAO;
import com.one9.dao.EmployeesDAO;
import com.one9.dao.SessionDAO;
import com.one9.exception.LoginException;
import com.one9.model.CurrentUserSession;
import com.one9.model.Customers;
import com.one9.model.Employees;
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
	private EmployeesDAO eDao;
	
	@Autowired
	private SessionDAO sDao;
	
	@Override
	public String logIntoAccountCustomer(LoginDTO dto)throws LoginException {
		Customers existingCustomer= cDao.findByMobileNumber(dto.getMobileNumber());
		if(existingCustomer == null) {
			throw new LoginException("Please Enter a valid mobile number");
		}

		CurrentUserSession currentUserSession = sDao.findByUserId(existingCustomer.getMobileNumber());

		if(currentUserSession!=null) {
			throw new LoginException("User already login with this userId");
		}

		if(existingCustomer.getMobileNumber().equals(dto.getMobileNumber()) && existingCustomer.getPassword().equals(dto.getPassword())) {
			String key= RandomString.make(6);
			CurrentUserSession newCurrentUserSession = new CurrentUserSession(existingCustomer.getMobileNumber(), key, LocalDateTime.now(), "customer");
			sDao.save(newCurrentUserSession);
			return  newCurrentUserSession.toString();
		} else {
			throw new LoginException("Invalid mobile and Password");
		}

	}

	@Override
	public String logOutFromAccountCustomer(String key)throws LoginException {
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
		}
		if(validCustomerSession.getType().equals("customer")) {
			sDao.delete(validCustomerSession);
			return "Logged Out !";
		}
		throw new LoginException("User Not Logged In with this number");
	}

	@Override
	public boolean isLoginCustomer(String key) throws LoginException {
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		if(validCustomerSession == null) {
			return false;
		}
		if(validCustomerSession.getType().equals("customer")) {
			return true;
		}
		return false;
	}

	@Override
	public String logIntoAccountEmployee(LoginDTO dto) throws LoginException {
		Employees existingEmployee= eDao.findByMobileNumber(dto.getMobileNumber());
		if(existingEmployee == null) {
			throw new LoginException("Please Enter a valid mobile number");
		}

		CurrentUserSession currentUserSession = sDao.findByUserId(existingEmployee.getMobileNumber());

		if(currentUserSession!=null) {
			throw new LoginException("User already login with this userId");
		}

		if(existingEmployee.getMobileNumber().equals(dto.getMobileNumber()) && existingEmployee.getPassword().equals(dto.getPassword())) {
			String key= RandomString.make(6);
			CurrentUserSession newCurrentUserSession = new CurrentUserSession(existingEmployee.getMobileNumber(), key, LocalDateTime.now(), "employee");
			sDao.save(newCurrentUserSession);
			return  newCurrentUserSession.toString();
		} else {
			throw new LoginException("Invalid mobile and Password");
		}
	}

	@Override
	public String logOutFromAccountEmployee(String key) throws LoginException {
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		if(validCustomerSession == null) {
			throw new LoginException("Employee Not Logged In with this number");
		}
		if(validCustomerSession.getType().equals("employee")) {
			sDao.delete(validCustomerSession);
			return "Logged Out !";
		}
		throw new LoginException("Employee Not Logged In with this number");
	}

	@Override
	public boolean isLoginEmployee(String key) throws LoginException {
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		if(validCustomerSession == null) {
			return false;
		}
		if(validCustomerSession.getType().equals("employee")) {
			return true;
		}
		return false;
	}

}
