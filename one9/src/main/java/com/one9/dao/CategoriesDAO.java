package com.one9.dao;

import com.one9.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDAO extends JpaRepository<Categories, Integer> {
}
