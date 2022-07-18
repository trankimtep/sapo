package com.example.demo.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Category;


public class CategoryRowMapper implements RowMapper<Category>{

    @Autowired
    private Category category;
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        category.setId(rs.getString("id"));
        category.setCategory_code(rs.getString("category_code"));
        category.setCategory_name(rs.getString("category_name"));
        category.setDescriptions(rs.getString("descriptions"));
        category.setCreated_date(rs.getTimestamp("created_date").toLocalDateTime());
        category.setEdited_date(rs.getTimestamp("editted_date").toLocalDateTime());
        return category;
    }
    
}
