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
		System.out.println("Menu:");
		System.out.println("	1. Khoi tao cac bang");
		System.out.println("	2. Loc san pham co chua tu 'Dien thoai' va thuoc danh muc 'Apple'");
		System.out.println("	3. Dem so luong san pham trong moi danh muc");
		System.out.println("	4. Xoa danh muc va cac san pham thuoc danh muc do");
		System.out.println("	5. Loc ra 10 san pham co so luong ban nhieu nhat");
	}
	
}
