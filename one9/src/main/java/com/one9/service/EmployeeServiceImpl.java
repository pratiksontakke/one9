package com.one9.service;

import com.one9.exception.EmployeeException;
import com.one9.model.Employees;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public Employees addEmployee(Employees employee) throws EmployeeException {
        return null;
    }

    @Override
    public Employees updateEmployee(Employees employee) throws EmployeeException {
        return null;
    }

    @Override
    public Employees getEmployee(Integer id) throws EmployeeException {
        return null;
    }

    @Override
    public List<Employees> viewAllEmployee() throws EmployeeException {
        return null;
    }
}
