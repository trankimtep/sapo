package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Product;

import java.sql.SQLException;
import java.util.List;

@Service
public interface ProductService {
    public List<Product> getListProduct() throws SQLException;
}
