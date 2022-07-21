package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/admin/Inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("")
	public ResponseEntity<?> getListInventory(){
		return null;
	}

	@PostMapping("")
	public ResponseEntity<?> postListInventory(){
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putListInventory(){
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteListInventory(){
		return null;
	}

}
