package com.one9.dao;

import com.one9.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesDAO extends JpaRepository<Employees, Integer> {
}
