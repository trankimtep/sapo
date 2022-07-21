package com.example.demo.service.imp;

import org.springframework.stereotype.Component;

import com.example.demo.service.ProductService;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.dao.imp.ProductDaoImplementation;
import com.example.demo.model.Product;

@Component
public class ProductServiceImp implements ProductService {
    @Override
    public List<Product> getListProduct() throws SQLException{
        return new ProductDaoImplementation().getProducts();
    }
}
