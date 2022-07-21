package com.example.demo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import com.example.demo.util.DatabaseConnection;

public class ProductDaoImplementation implements ProductDao{
    static Connection con
        = DatabaseConnection.getConnection();
  
    @Override
    public int add(Product prod)
        throws SQLException
    {
  
        String query
            = "INSERT INTO product VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, prod.getId());
        ps.setString(2, prod.getProduct_code());
        ps.setString(3, prod.getCategory());
        ps.setString(4, prod.getInventory());
        ps.setString(5, prod.getProduct_name());
        ps.setString(6, prod.getDescription());
        ps.setString(7, prod.getPhoto_link());
        ps.setString(3, prod.getNumber_product()+"");
        ps.setString(3, prod.getNumber_sell_product()+"");
        ps.setString(8, prod.getCreated_date().toString());
        ps.setString(9, prod.getEdited_date().toString());
        int n = ps.executeUpdate();
        return n;
    }
  
    @Override
    public void delete(int id)
        throws SQLException
    {
        String query
            = "DELETE FROM product WHERE id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
  
    @Override
    public Product getProduct(int id)
        throws SQLException
    {
  
        String query
            = "SELECT * FROM product WHERE id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
  
        ps.setInt(1, id);
        Product prod = new Product();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
  
        while (rs.next()) {
            check = true;
            prod.setId(rs.getString("id"));
            prod.setProduct_code(rs.getString("product_code"));
            prod.setCategory(rs.getString("category"));
            prod.setInventory(rs.getString("inventory"));
            prod.setProduct_name(rs.getString("product_name"));
            prod.setDescription(rs.getString("descriptions"));
            prod.setPhoto_link(rs.getString("photo_link"));
            prod.setNumber_product(rs.getInt("number_product"));
            prod.setNumber_sell_product(rs.getInt("number_sell_product"));
            prod.setCreated_date(rs.getTimestamp("created_date"));
            prod.setEdited_date(rs.getTimestamp("edited_date"));

        }
  
        if (check == true) {
            return prod;
        }
        else
            return null;
    }
  
    @Override
    public List<Product> getProducts()
        throws SQLException
    {
        String query = "SELECT * FROM product";
        PreparedStatement ps
            = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Product> ls = new ArrayList();
  
        while (rs.next()) {
            Product prod = new Product();
            prod.setId(rs.getString("id"));
            prod.setProduct_code(rs.getString("product_code"));
            prod.setCategory(rs.getString("category"));
            prod.setInventory(rs.getString("inventory"));
            prod.setProduct_name(rs.getString("product_name"));
            prod.setDescription(rs.getString("descriptions"));
            prod.setPhoto_link(rs.getString("photo_link"));
            prod.setNumber_product(rs.getInt("number_product"));
            prod.setNumber_sell_product(rs.getInt("number_sell_product"));
            prod.setCreated_date(rs.getTimestamp("created_date"));
            prod.setEdited_date(rs.getTimestamp("edited_date"));
            ls.add(prod);
        }
        return ls;
    }
  
    @Override
    public void update(Product prod)
        throws SQLException
    {
  
        String query
            = "UPDATE product SET inventory=?, "
              + " edited_date= ? where prod_id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, prod.getInventory());
        ps.setString(2, prod.getEdited_date().toString());
        ps.setString(3, prod.getId());
        ps.executeUpdate();
    }
}

