package com.roberthalf.webservice.inventory.InventoryAPIs.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.roberthalf.webservice.inventory.InventoryAPIs.exception.InentoryBadArgumentFoundException;
import com.roberthalf.webservice.inventory.InventoryAPIs.exception.InentoryNotFoundException;
import com.roberthalf.webservice.inventory.InventoryAPIs.models.Inventory;
import com.roberthalf.webservice.inventory.InventoryAPIs.service.InventoryRepository;

/**
 * This controller provide us the Inventory APIs 
 * 
 * @author Shailesh
 *
 */
@RestController
@RequestMapping("inventory")
public class InventoryController {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	
	@GetMapping
	public List<Inventory> getAllInventory(@RequestParam(value = "skip", required=false)  String skip, 
			@RequestParam(value = "limit", required=false) String limit) {
		List<Inventory> inventories = Collections.EMPTY_LIST;
		try {
			inventories = inventoryRepository.getInventoryItems(skip, limit);
		}catch(InentoryBadArgumentFoundException e) {
			e.getMessage();
		}
		final Resources < Inventory > resources = new Resources < > (inventories);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
		return inventories;
	}
	
	@PostMapping
	public ResponseEntity<Object> createInventory(@Valid @RequestBody Inventory inventory) {
		Inventory inventory2 = inventoryRepository.save(inventory);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(inventory2.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping("/{id}")
	public Inventory getInventoryById(@PathVariable("id") String id) {
		Optional<Inventory> inventory = inventoryRepository.findById(id);
		
		if(!inventory.isPresent()) {
			throw new InentoryNotFoundException("id - "+id);
		}
		return inventory.get();
	}
	
}
