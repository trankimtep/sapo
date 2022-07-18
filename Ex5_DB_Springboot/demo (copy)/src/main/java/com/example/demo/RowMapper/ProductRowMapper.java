package com.example.demo.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Product;


public class ProductRowMapper implements RowMapper<Product>{

    @Autowired
    private Product product;
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        product.setId(rs.getString("id"));
        product.setProduct_code(rs.getString("product_code"));
        product.setCategory(rs.getString("category"));
        product.setInventory(rs.getString("inventory"));
        product.setProduct_name(rs.getString("product_name"));
        product.setPhoto_link(rs.getString("photo_link"));
        product.setNumber_product(rs.getInt("number_product"));
        product.setNumber_sell_product(rs.getInt("number_sell_product"));
        product.setDescription(rs.getString("descriptions"));
        product.setCreated_date(rs.getTimestamp("created_date").toLocalDateTime());
        product.setEdited_date(rs.getTimestamp("created_date").toLocalDateTime());
        return product;
    }
    
}
