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

import com.example.demo.dao.imp.InventoryDaoImplementation;
import com.example.demo.model.Inventory;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@ResponseBody
@RequestMapping("/admin/Inventory")
public class InventoryController {

    @GetMapping("")
	public ResponseEntity<?> getListInventory() throws SQLException{
		List<Inventory> Inventorys = new InventoryDaoImplementation().getInventories();
		return ResponseEntity.status(HttpStatus.OK).body(Inventorys);
	}

	@GetMapping("/{id}")
    public ResponseEntity<?> getInventoryById(@PathVariable int id) throws SQLException {
        Inventory result = new InventoryDaoImplementation().getInventory(id);
        return ResponseEntity.ok(result);
    }

	@PostMapping("")
	public int postInventory(@RequestBody Inventory Inventory) throws SQLException {
		return  new InventoryDaoImplementation().add(Inventory);
	}

	@PutMapping("/{id}")
    public ResponseEntity<?> putInventory(@RequestBody Inventory inventory, @PathVariable int id) throws SQLException {
        try {
            //Inventory existInventory = new Inventory();
			InventoryDaoImplementation inventoryDaoImplementation = new InventoryDaoImplementation();
			//existInventory =  InventoryDaoImplementation.getInventory(id);
            inventory.setId(id);            
            inventoryDaoImplementation.add(inventory);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws SQLException {
		InventoryDaoImplementation InventoryDaoImplementation = new InventoryDaoImplementation();
        InventoryDaoImplementation.delete(id);
    }

}
