package com.one9.service;

import com.one9.exception.CategorieException;
import com.one9.model.Categories;

import java.util.List;

public interface CategorieService {
    public Categories addCategories(Categories categorie) throws CategorieException;

    public Categories updateCategories(Categories categorie) throws CategorieException;

    public Categories deleteCategories(Integer id) throws CategorieException;

    public Categories getCategorie(Integer id) throws CategorieException;

    public List<Categories> getAllCategories() throws CategorieException;

}
