package com.roberthalf.webservice.inventory.InventoryAPIs.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roberthalf.webservice.inventory.InventoryAPIs.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String>, InventoryDAO{

}
