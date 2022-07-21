package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Category;

public interface CategoryDao {
    public int add(Category emp)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public Category getCategory(int id)
        throws SQLException;
    public List<Category> getCategories()
        throws SQLException;
    public void update(Category emp)
        throws SQLException;
}
