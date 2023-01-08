package com.one9.service;

import com.one9.model.Categories;

import java.util.List;

public interface CategorieService {
    public Categories addCategories(Categories categorie);

    public Categories updateCategories(Categories categorie);

    public Categories deleteCategories(Categories categorie);

    public Categories getCategorie(Integer cid);

    public List<Categories> getAllCategories();

}
