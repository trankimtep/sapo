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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.imp.ProductDaoImplementation;
import com.example.demo.model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@ResponseBody
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
	public int postProduct(@RequestBody Product product) throws SQLException {
		return  new ProductDaoImplementation().add(product);
	}

	@PutMapping("/{id}")
    public ResponseEntity<?> putProduct(@RequestBody Product product, @PathVariable int id) throws SQLException {
        try {
            //Product existProduct = new Product();
			ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
			//existProduct =  productDaoImplementation.getProduct(id);
            product.setId(id);            
            productDaoImplementation.add(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws SQLException {
		ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
        productDaoImplementation.delete(id);
    }

}
