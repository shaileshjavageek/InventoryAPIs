package com.roberthalf.webservice.inventory.InventoryAPIs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Manufacturer {
	
	@Id
    @GeneratedValue
	private int id;

	@NotNull(message="Manufacturer name is mandatory")
    @NotBlank(message="Manufacturer name is mandatory")
	@Column(name = "name",unique=true)
	private String name;
	
	@Column(name = "home_page")
	private String homePage;
	
	@Column(name = "phone")
	private String phone;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
