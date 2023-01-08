package com.one9.dao;

import com.one9.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsDAO extends JpaRepository<Products, Integer> {
}
