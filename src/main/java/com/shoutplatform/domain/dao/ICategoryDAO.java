/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoutplatform.domain.dao;

import com.shoutplatform.domain.objects.Category;
import java.util.List;

/**
 *
 * @author luka
 */
public interface ICategoryDAO {
    
    public Category getCategoryById(int id);
    public List<Category> getAllCategories();
    public Category getCategoryWithQuestions(int id);
    public void insertCategory(Category category);
    
    
    /*
    public void insertUser(User user);

    public User getUserById(Integer userId);

    public List<User> getAllUsers();

    public void updateUser(User user);

    public void deleteUser(Integer userId);
    */
}





 

