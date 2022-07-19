package com.example.demo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo.util.DatabaseConnection;

public class Service {
    static Connection con
        = DatabaseConnection.getConnection();
    
    public Service(){}

    public void dienThoaiApple () throws SQLException{
        String query
            = "SELECT * FROM product WHERE product_name LIKE 'Dien Thoai' AND category LIKE 'Apple'";
        System.out.println(query);
        PreparedStatement ps
            = con.prepareStatement(query);
  
        //ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        boolean check = false;
  
        while (rs.next()) {
            check = true;
            System.out.println(rs.getString("id")); 
            System.out.println(rs.getString("product_code")); 
            System.out.println(rs.getString("category")); 
            System.out.println(rs.getString("inventory")); 
            System.out.println(rs.getString("product_name")); 
            System.out.println(rs.getString("descriptions")); 
            System.out.println(rs.getString("photo_link")); 
            System.out.println(rs.getInt("number_product")); 
            System.out.println(rs.getInt("number_sell_product")); 
            System.out.println(rs.getTimestamp("created_date")); 
            System.out.println(rs.getTimestamp("edited_date"));  
            System.out.println("======");
        }
        if (!check){
            System.out.println("There is no object match");
        }
    }

    public void coutEachCategory() throws SQLException{
        String query
            = "SELECT category, COUNT(category) as count FROM product GROUP BY category ORDER BY COUNT(category) DESC";
        System.out.println(query);
        PreparedStatement ps
            = con.prepareStatement(query);
  
        //ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        boolean check = false;
  
        while (rs.next()) {
            check = true;
            System.out.println(rs.getString("category")); 
            System.out.println(rs.getString("count")); 
            System.out.println("======");
        }
        if (!check){
            System.out.println("There is no object match");
        }
    }


}
