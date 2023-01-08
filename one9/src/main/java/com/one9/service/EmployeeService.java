package com.one9.service;

import com.one9.exception.EmployeeException;
import com.one9.model.Employees;

import java.util.List;

public interface EmployeeService {
    public Employees addEmployee(Employees employee) throws EmployeeException;
    public Employees updateEmployee(Employees employee) throws EmployeeException;
    public Employees getEmployee(Integer id) throws EmployeeException;
    public List<Employees> viewAllEmployee() throws EmployeeException;


}
