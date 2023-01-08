package com.one9.dao;

import com.one9.model.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippersDAO extends JpaRepository<Shippers, Integer> {
}
