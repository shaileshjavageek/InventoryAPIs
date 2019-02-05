package com.roberthalf.webservice.inventory.InventoryAPIs.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roberthalf.webservice.inventory.InventoryAPIs.models.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>{

}
