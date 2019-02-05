package com.roberthalf.webservice.inventory.InventoryAPIs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roberthalf.webservice.inventory.InventoryAPIs.exception.ManufacturerNotFoundException;
import com.roberthalf.webservice.inventory.InventoryAPIs.models.Manufacturer;
import com.roberthalf.webservice.inventory.InventoryAPIs.service.ManufacturerRepository;

/**
 * Rest Controller for manufacturer APIs
 * 
 * @author Shailesh
 *
 */
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	@GetMapping("/{id}")
	public Manufacturer getManufacturerDetailsById(@PathVariable("id") String id) {
		Optional<Manufacturer> manufacturer = manufacturerRepository.findById(Integer.parseInt(id));
		
		if(!manufacturer.isPresent()) {
			throw new ManufacturerNotFoundException("id - "+id);
		}
		return manufacturer.get();
	}
	

}
