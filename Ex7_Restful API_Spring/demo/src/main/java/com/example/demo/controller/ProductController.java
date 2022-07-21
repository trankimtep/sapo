package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.imp.ProductDaoImplementation;
import com.example.demo.model.Product;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/admin/Product")
public class ProductController {

    @GetMapping("")
	public ResponseEntity<?> getListProduct() throws SQLException{
		List<Product> products = new ProductDaoImplementation().getProducts();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	@GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) throws SQLException {
        Product result = new ProductDaoImplementation().getProduct(id);
        return ResponseEntity.ok(result);
    }

	@PostMapping("")
	public ResponseEntity<?> postProduct (@RequestBody Product newProduct) throws SQLException {
		int result = new ProductDaoImplementation().add(newProduct);
	  	return ResponseEntity.ok(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putProduct (@RequestBody Product newProduct) throws SQLException {
		new ProductDaoImplementation().update(newProduct);
	  	return ResponseEntity.ok(newProduct);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteListProduct(){
		return null;
	}

}
