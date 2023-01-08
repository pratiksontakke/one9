package com.one9.service;

import com.one9.exception.CategorieException;
import com.one9.model.Categories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategorieService {

    @Override
    public Categories addCategories(Categories categorie) throws CategorieException {
        return null;
    }

    @Override
    public Categories updateCategories(Categories categorie) throws CategorieException {
        return null;
    }

    @Override
    public Categories deleteCategories(Categories categorie) throws CategorieException {
        return null;
    }

    @Override
    public Categories getCategorie(Integer cid) throws CategorieException {
        return null;
    }

    @Override
    public List<Categories> getAllCategories() throws CategorieException {
        return null;
    }
}
