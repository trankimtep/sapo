package com.example.demo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.CategoryDao;
import com.example.demo.model.Category;
import com.example.demo.util.DatabaseConnection;

public class CategoryDaoImplementation implements CategoryDao{
    static Connection con
        = DatabaseConnection.getConnection();
  
    @Override
    public int add(Category inv)
        throws SQLException
    {
  
        String query
            = "INSERT INTO category VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, inv.getId());
        ps.setString(2, inv.getCategory_code());
        ps.setString(3, inv.getCategory_name());
        ps.setString(4, inv.getDescriptions());
        ps.setString(5, inv.getCreated_date().toString());
        ps.setString(6, inv.getEdited_date().toString());
        int n = ps.executeUpdate();
        return n;
    }
  
    @Override
    public void delete(int id)
        throws SQLException
    {
        String query
            = "DELETE FROM category WHERE id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
  
    @Override
    public Category getCategory(int id)
        throws SQLException
    {
  
        String query
            = "SELECT * FROM category WHERE id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
  
        ps.setInt(1, id);
        Category inv = new Category();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
  
        while (rs.next()) {
            check = true;
            inv.setId(rs.getString("id"));
            inv.setCategory_code(rs.getString("category_code"));
            inv.setCategory_name(rs.getString("category_name"));
            inv.setCreated_date(rs.getTimestamp("created_date"));
        }
  
        if (check == true) {
            return inv;
        }
        else
            return null;
    }
  
    @Override
    public List<Category> getCategories()
        throws SQLException
    {
        String query = "SELECT * FROM iventory WHERE id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Category> ls = new ArrayList();
  
        while (rs.next()) {
            Category inv = new Category();
            inv.setId(rs.getString("id"));
            inv.setCategory_code(rs.getString("iventory_code"));
            inv.setCategory_name(rs.getString("category_name"));
            inv.setDescriptions(rs.getString("descriptions"));
            inv.setCreated_date(rs.getTimestamp("created_date"));
            inv.setEdited_date(rs.getTimestamp("edited_date"));
            ls.add(inv);
        }
        return ls;
    }
  
    @Override
    public void update(Category inv)
        throws SQLException
    {
  
        String query
            = "UPDATE category SET descriptions=?, "
              + " edited_date= ? where inv_id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, inv.getDescriptions());
        ps.setString(2, inv.getEdited_date().toString());
        ps.setString(3, inv.getId());
        ps.executeUpdate();
    }
}

