package com.example.demo.main;

import java.sql.SQLException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dao.imp.ProductDaoImplementation;
import com.example.demo.dao.imp.Service;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws SQLException {
		System.out.println("======================================");
		System.out.println("\n \n \n \n");
		// TODO Auto-generated method stub
		ProductDaoImplementation prodDao = new ProductDaoImplementation();
		//System.out.println(prodDao.getProduct(2).toString());
		Service ser = new Service();
		ser.dienThoaiApple();
		ser.coutEachCategory();
		System.out.println("\n \n \n \n");
		System.out.println("======================================");
	}
	
}
