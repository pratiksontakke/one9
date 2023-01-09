package com.one9.service;

import com.one9.exception.CategorieException;
import com.one9.exception.LoginException;
import com.one9.model.Categories;

import java.util.List;

public interface CategorieService {
    public Categories addCategories(Categories categorie, String key) throws CategorieException, LoginException;

    public Categories updateCategories(Categories categorie, String key) throws CategorieException, LoginException;

    public Categories deleteCategories(Integer id, String key) throws CategorieException, LoginException;

    public Categories getCategorie(Integer id, String key) throws CategorieException, LoginException;

    public List<Categories> getAllCategories(String key) throws CategorieException, LoginException;

}
