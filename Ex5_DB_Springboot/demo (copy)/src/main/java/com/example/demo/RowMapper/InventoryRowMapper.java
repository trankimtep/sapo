package com.example.demo.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Inventory;


public class InventoryRowMapper implements RowMapper <Inventory> {
    @Autowired
    private Inventory inventory;
    @Override
    public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        inventory.setId(rs.getString("id"));
        inventory.setInventory_code(rs.getString("inventory_code"));
        inventory.setAddress(rs.getString("address"));
        inventory.setCreated_date(rs.getTimestamp("created_date").toLocalDateTime());
        inventory.setEdited_date(rs.getTimestamp("created_date").toLocalDateTime());
        return inventory;
    }
    
    
}
