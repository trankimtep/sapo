package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private  JdbcTemplate JdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO product VALUES (?,?,?,?,?,?,?,?,?,?,?)";	
		int result = JdbcTemplate.update(sql,"12","javajdbc","B", "HaDong", "Dien thoai","From Vietnam","https://www.facebook.com/anh",70,60, "2022-01-01 15:30:00", "2022-07-01 15:30:00");
		if (result > 0){
			System.out.println("Query done!!!!!");
		}
	}

}
