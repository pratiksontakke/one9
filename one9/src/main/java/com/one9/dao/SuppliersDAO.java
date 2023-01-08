package com.one9.dao;

import com.one9.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersDAO extends JpaRepository<Suppliers, Integer> {
}
