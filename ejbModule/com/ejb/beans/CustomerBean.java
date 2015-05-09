package com.ejb.beans;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.interfaces.CustomerDAO;
import com.persistence.entities.Customer;

/*
 * CRUD
 * create	persist()
 * read		find(), executeQuery() >> jqpl ist auf objekt ausgerichtet
 * update	merge(instanz), refresh(datenbank)
 * delete	remove()
 * 
 * JPQL Abfragen mit createQuery() erzeugen
 * NamedQueries sind sehr wichtig für die Wartbarkeit >> mit Annotation in Entität deklarieren
 */

@Stateless
@Remote(CustomerDAO.class) // remote interface
public class CustomerBean implements CustomerDAO
{
	@PersistenceContext
	private EntityManager em; // für Zugriff auf Daten 

	@Override
	public Customer create(Customer customer)
	{
		em.persist(customer); // dieser Instanz wird gleich der automatisch erzeugte Primärschlüssel zugewiesen
		return customer;
	}

	@Override
	public Customer update(Customer customer)
	{
		return em.merge(customer); // gibt Kopie der Instanz zurück
	}

	@Override
	public Customer getCustomer(int id)
	{
		return em.find(Customer.class, id);
	}

	@Override
	public void remove(int id)
	{
		Customer CustomerToDelete = getCustomer(id);
		em.remove(CustomerToDelete);		
	}

	@Override
	public List<Customer> getAllCustomers()
	{
		return
				em.createNamedQuery(Customer.QUERY_GETALL, Customer.class)
				.getResultList();
	}
	

}
