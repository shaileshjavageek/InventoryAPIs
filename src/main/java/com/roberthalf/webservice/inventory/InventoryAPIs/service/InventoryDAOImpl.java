package com.roberthalf.webservice.inventory.InventoryAPIs.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roberthalf.webservice.inventory.InventoryAPIs.exception.InentoryBadArgumentFoundException;
import com.roberthalf.webservice.inventory.InventoryAPIs.models.Inventory;

@Repository
public class InventoryDAOImpl implements InventoryDAO{
	
	@Autowired
	private EntityManager entityManager; 

	@Override
	@SuppressWarnings("unchecked")
	public List<Inventory> getInventoryItems(String skip, String limit) {
		List<Inventory> inventories = Collections.EMPTY_LIST;
		try {
			Session session = null;
			if (entityManager == null
			    || (session = entityManager.unwrap(Session.class)) == null) {
	
			    throw new NullPointerException();
			}		
			Query<Inventory> query = session.createQuery("From Inventory");
			if(skip !=null && limit!=null) {
				query.setFirstResult(Integer.parseInt(skip));
				query.setMaxResults(Integer.parseInt(limit));
			}
			inventories = query.list();
		}catch(InentoryBadArgumentFoundException e) {
			e.printStackTrace();
		}
		return inventories;
	}
	
}
