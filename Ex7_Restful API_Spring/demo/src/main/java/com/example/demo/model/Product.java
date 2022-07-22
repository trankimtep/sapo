package com.example.demo.model;

//import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;
@Component
public class Product {
    private int id;
    private String product_code;
    private String category;
    private String inventory;
    private String product_name;
    private String description;
    private String photo_link;
    private int number_product;
    private int number_sell_product;
    private Timestamp created_date;
    private Timestamp edited_date;

    public Product(){}

    public Product(String id, String product_code, String category, String inventory, 
                    String product_name, String description, String photo_link, 
                    int number_product, int number_sell_product, Timestamp created_date, Timestamp edited_date){
    this.id = Integer.parseInt(id);
    this.product_code = product_code;
    this.category = category;
    this.inventory = inventory;
    this.product_name = product_name;
    this.description = description;
    this.photo_link = photo_link;
    this.number_product = number_product;
    this.number_sell_product = number_sell_product;
    this.created_date = created_date;
    this. edited_date = edited_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    public int getNumber_product() {
        return number_product;
    }

    public void setNumber_product(int number_product) {
        this.number_product = number_product;
    }

    public int getNumber_sell_product() {
        return number_sell_product;
    }

    public void setNumber_sell_product(int number_sell_product) {
        this.number_sell_product = number_sell_product;
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
    public String toString(){
        return "[ id=" + id + "\n product_code=" + product_code + "\n category="+ category 
                + "\n inventory=" + inventory + "\n product_name=" + product_name 
                + "\n description=" + description + "\n photo_link=" + photo_link 
                + "\n number_product=" + number_product + "\n number_sell_product=" + number_sell_product 
                +"\n created_date=" + created_date + "\n edited_date=" + edited_date + "]";
    }
}
