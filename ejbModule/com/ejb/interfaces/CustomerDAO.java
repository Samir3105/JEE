package com.ejb.interfaces;
import java.util.List;



import com.persistence.entities.Customer;

public interface CustomerDAO
{	
	public Customer create(Customer customer);
	public Customer update(Customer customer);
	public Customer getCustomer(int id);
	public void remove(int id);
	public List<Customer> getAllCustomers();
}
