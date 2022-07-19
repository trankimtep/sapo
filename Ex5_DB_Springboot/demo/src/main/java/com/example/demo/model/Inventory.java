package com.example.demo.model;

import java.sql.Timestamp;
// import java.util.Date;

public class Inventory {
    private String id, inventory_code, address;
    private Timestamp created_date;
    private Timestamp edited_date;
    public Inventory(){}
    public Inventory(String id, String inventory_code, String address, Timestamp created_date, Timestamp edited_date){
        this.id = id;
        this. inventory_code = inventory_code;
        this.address = address;
        this.created_date = created_date;
        this.edited_date = edited_date;  
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInventory_code() {
        return inventory_code;
    }

    public void setInventory_code(String inventory_code) {
        this.inventory_code = inventory_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp Timestamp) {
        this.created_date = Timestamp;
    }

    public Timestamp getEdited_date() {
        return edited_date;
    }

    public void setEdited_date(Timestamp Timestamp) {
        this.edited_date = Timestamp;
    }
    @Override
    public String toString(){
        return "[ id=" + id + " inventory_code=" + inventory_code + " address=" 
                + address + "created_date=" + created_date + "edited_date=" + edited_date + "]";
    }    
}

