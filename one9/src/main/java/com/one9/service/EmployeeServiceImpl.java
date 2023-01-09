package com.one9.service;

import com.one9.dao.EmployeesDAO;
import com.one9.exception.EmployeeException;
import com.one9.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeesDAO edao;

    @Override
    public Employees addEmployee(Employees employee) throws EmployeeException {
        return edao.save(employee);
    }

    @Override
    public Employees updateEmployee(Employees employee) throws EmployeeException {
        Optional<Employees> employees = edao.findById(employee.getEmployeeID());
        if(employees.isPresent()) {
            return edao.save(employee);
        } else {
            throw new EmployeeException("Employee not found with id : " + employee.getEmployeeID());
        }
    }

    @Override
    public Employees getEmployee(Integer id) throws EmployeeException {
        Optional<Employees> employees = edao.findById(id);
        if(employees.isPresent()) {
            return employees.get();
        } else {
            throw new EmployeeException("Employee not found with id : " + id);
        }
    }

    @Override
    public List<Employees> viewAllEmployee() throws EmployeeException {
        List<Employees> employees = edao.findAll();
        if(employees.isEmpty()) {
            throw new EmployeeException("Employee list is empty");
        } else {
            return employees;
        }
    }
}
