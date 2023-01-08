package com.one9.service;

import com.one9.model.Employees;

import java.util.List;

public interface EmployeeService {
    public Employees addEmployee(Employees employee);
    public Employees updateEmployee(Employees employee);
    public Employees getEmployee(Integer id);
    public List<Employees> viewAllEmployee();


}
