package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Product;

public interface ProductDao {
    public int add(Product emp)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public Product getProduct(int id)
        throws SQLException;
    public List<Product> getProducts()
        throws SQLException;
    public void update(Product emp)
        throws SQLException;
}
