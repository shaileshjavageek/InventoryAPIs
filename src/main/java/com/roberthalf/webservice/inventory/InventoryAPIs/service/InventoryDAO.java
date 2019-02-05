package com.roberthalf.webservice.inventory.InventoryAPIs.service;

import java.util.List;

import com.roberthalf.webservice.inventory.InventoryAPIs.models.Inventory;

public interface InventoryDAO {

	public List<Inventory> getInventoryItems(String skip, String limit);
	
	
}
