package com.one9.service;

import com.one9.dao.CategoriesDAO;
import com.one9.dao.EmployeesDAO;
import com.one9.dao.SessionDAO;
import com.one9.exception.CategorieException;
import com.one9.exception.LoginException;
import com.one9.model.Categories;
import com.one9.model.CurrentUserSession;
import com.one9.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategorieService {

    @Autowired
    CategoriesDAO cdao;

    @Autowired
    EmployeesDAO edao;

    @Autowired
    SessionDAO sdao;

    @Autowired
    LoginService lSer;

    @Override
    public Categories addCategories(Categories categorie, String key) throws CategorieException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            employee.getCategories().add(categorie);
            edao.save(employee);
            return categorie;
        } else {
            throw new LoginException("Employee not login.");
        }
    }

    @Override
    public Categories updateCategories(Categories categorie, String key) throws CategorieException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            for(Categories c : employee.getCategories()) {
                if(Objects.equals(c.getCategoryID(), categorie.getCategoryID())) {
                    c.setCategoryName(categorie.getCategoryName());
                    c.setDescription(categorie.getDescription());
                    edao.save(employee);
                    return c;
                }
            }
            throw new CategorieException("Categorie not found with id : " + categorie.getCategoryID() + " in your list");
        } else {
            throw new LoginException("Employee not login.");
        }

    }

    @Override
    public Categories deleteCategories(Integer id, String key) throws CategorieException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            for(Categories c : employee.getCategories()) {
                if(Objects.equals(c.getCategoryID(), id)) {
                    employee.getCategories().remove(c);
                    edao.save(employee);
                    return c;
                }
            }
            throw new CategorieException("Categorie not found with id : " + id);
        } else {
            throw new LoginException("Employee not login.");
        }
    }

    @Override
    public Categories getCategorie(Integer id, String key) throws CategorieException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            Optional<Categories> categorie = cdao.findById(id);
            if(categorie.isPresent()) {
                return categorie.get();
            } else {
                throw new CategorieException("Categorie not found with id : " + id);
            }
        } else {
            throw new LoginException("Employee not login.");
        }

    }

    @Override
    public List<Categories> getAllCategories(String key) throws CategorieException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            List<Categories> categories = cdao.findAll();
            if(categories.isEmpty()) {
                throw new CategorieException("Categorie list is empty");
            } else {
                return categories;
            }
        } else {
            throw new LoginException("Employee not login.");
        }
    }

}
