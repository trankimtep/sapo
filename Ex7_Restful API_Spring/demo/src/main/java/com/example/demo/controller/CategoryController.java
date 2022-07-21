package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/admin/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("")
	public ResponseEntity<?> getListCategory(){
		return null;
	}

	@PostMapping("")
	public ResponseEntity<?> postListCategory(){
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putListCategory(){
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteListCategory(){
		return null;
	}

}
