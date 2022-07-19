package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Inventory;

public interface InventoryDao {
    public int add(Inventory emp)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public Inventory getInventory(int id)
        throws SQLException;
    public List<Inventory> getInventories()
        throws SQLException;
    public void update(Inventory emp)
        throws SQLException;
}
