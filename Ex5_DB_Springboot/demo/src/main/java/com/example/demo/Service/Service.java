package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Service {
    public Service (){
    }
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void create(String sql){
        jdbcTemplate.execute(sql);
    }
}
