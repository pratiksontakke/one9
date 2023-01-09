package com.one9.service;

import com.one9.dao.CategoriesDAO;
import com.one9.exception.CategorieException;
import com.one9.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategorieService {

    @Autowired
    CategoriesDAO cdao;
    @Override
    public Categories addCategories(Categories categorie) throws CategorieException {
        return cdao.save(categorie);
    }

    @Override
    public Categories updateCategories(Categories categorie) throws CategorieException {
        Optional<Categories> categories = cdao.findById(categorie.getCategoryID());
        if(categories.isPresent()) {
            return cdao.save(categorie);
        } else {
            throw new CategorieException("Categorie not found with id : " + categorie.getCategoryID());
        }
    }

    @Override
    public Categories deleteCategories(Integer id) throws CategorieException {
        Optional<Categories> categories = cdao.findById(id);
        if(categories.isPresent()) {
            cdao.deleteById(id);
            return categories.get();
        } else {
            throw new CategorieException("Categorie not found with id : " + id);
        }
    }

    @Override
    public Categories getCategorie(Integer id) throws CategorieException {
        Optional<Categories> categories = cdao.findById(id);
        if(categories.isPresent()) {
            return categories.get();
        } else {
            throw new CategorieException("Categorie not found with id : " + id);
        }
    }

    @Override
    public List<Categories> getAllCategories() throws CategorieException {
        List<Categories> categories = cdao.findAll();
        if(categories.isEmpty()) {
            throw new CategorieException("Categorie list is empty.");
        } else {
            return categories;
        }
    }
}
