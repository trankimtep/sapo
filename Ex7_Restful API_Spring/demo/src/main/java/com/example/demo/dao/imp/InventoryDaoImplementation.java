package com.example.demo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.InventoryDao;
import com.example.demo.model.Inventory;
import com.example.demo.util.DatabaseConnection;

public class InventoryDaoImplementation implements InventoryDao{
    static Connection con
        = DatabaseConnection.getConnection();
  
    @Override
    public int add(Inventory inv)
        throws SQLException
    {
  
        String query
            = "INSERT INTO inventory VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setInt(1, inv.getId());
        ps.setString(2, inv.getInventory_code());
        ps.setString(3, inv.getAddress());
        ps.setString(4, inv.getCreated_date().toString());
        ps.setString(5, inv.getEdited_date().toString());
        int n = ps.executeUpdate();
        return n;
    }
  
    @Override
    public void delete(int id)
        throws SQLException
    {
        String query
            = "DELETE FROM inventory WHERE id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
  
    @Override
    public Inventory getInventory(int id)
        throws SQLException
    {
  
        String query
            = "SELECT * FROM inventory WHERE id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
  
        ps.setInt(1, id);
        Inventory inv = new Inventory();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
  
        while (rs.next()) {
            check = true;
            inv.setId(rs.getInt("id"));
            inv.setInventory_code(rs.getString("inventory_code"));
            inv.setAddress(rs.getString("address"));
            inv.setCreated_date(rs.getTimestamp("created_date"));
        }
  
        if (check == true) {
            return inv;
        }
        else
            return null;
    }
  
    @Override
    public List<Inventory> getInventories()
        throws SQLException
    {
        String query = "SELECT * FROM inventory";
        PreparedStatement ps
            = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Inventory> ls = new ArrayList();
  
        while (rs.next()) {
            Inventory inv = new Inventory();
            inv.setId(rs.getInt("id"));
            inv.setInventory_code(rs.getString("inventory_code"));
            inv.setAddress(rs.getString("address"));
            inv.setCreated_date(rs.getTimestamp("created_date"));
            inv.setEdited_date(rs.getTimestamp("edited_date"));
            ls.add(inv);
        }
        return ls;
    }
  
    @Override
    public void update(Inventory inv)
        throws SQLException
    {
  
        String query
            = "UPDATE inventory SET address=?, "
              + " edited_date= ? where inv_id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, inv.getAddress());
        ps.setString(2, inv.getEdited_date().toString());
        ps.setInt(3, inv.getId());
        ps.executeUpdate();
    }
}

