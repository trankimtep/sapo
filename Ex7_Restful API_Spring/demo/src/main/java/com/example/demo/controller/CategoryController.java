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

import com.example.demo.dao.imp.CategoryDaoImplementation;
import com.example.demo.model.Category;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@ResponseBody
@RequestMapping("/admin/Category")
public class CategoryController {

    @GetMapping("")
	public ResponseEntity<?> getListCategory() throws SQLException{
		List<Category> products = new CategoryDaoImplementation().getCategories();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	@GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) throws SQLException {
        Category result = new CategoryDaoImplementation().getCategory(id);
        return ResponseEntity.ok(result);
    }

	@PostMapping("")
	public int postCategory(@RequestBody Category product) throws SQLException {
		return  new CategoryDaoImplementation().add(product);
	}

	@PutMapping("/{id}")
    public ResponseEntity<?> putCategory(@RequestBody Category product, @PathVariable int id) throws SQLException {
        try {
            //Category existCategory = new Category();
			CategoryDaoImplementation productDaoImplementation = new CategoryDaoImplementation();
			//existCategory =  productDaoImplementation.getCategory(id);
            product.setId(id);            
            productDaoImplementation.add(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws SQLException {
		CategoryDaoImplementation productDaoImplementation = new CategoryDaoImplementation();
        productDaoImplementation.delete(id);
    }

}
