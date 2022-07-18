package com.example.demo.model;

import java.sql.Timestamp;


import org.springframework.stereotype.Component;
@Component
public class Category {
    private String id;
    private String category_code;
    private String category_name;
    private String descriptions;
    private Timestamp created_date;
    private Timestamp edited_date;
    public Category(){}
    public Category(String id, String category_code, String category_name, String descriptions, Timestamp created_date, Timestamp edited_date){
        this.id = id;
        this. category_code = category_code;
        this. category_name = category_name;
        this. descriptions = descriptions;
        this. created_date = created_date;
        this. edited_date = edited_date;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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
        return "[id=" + id + " category_code=" + category_code + " category_name=" 
                + category_name + " descriptions=" + descriptions + " created_date=" 
                + created_date + " edited_date=" + edited_date +"]";
    }
}
