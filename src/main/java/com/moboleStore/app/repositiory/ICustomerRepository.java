package com.moboleStore.app.repositiory;

import java.util.List;

import com.moboleStore.app.entity.Customer;
import com.moboleStore.app.exception.CustomerNotFoundException;



public interface ICustomerRepository {

	public Customer addCustomer(Customer Customer);
	public Customer updateCustomer(Customer Customer) throws CustomerNotFoundException;
	public Customer cancelCustomer(int Customerid) throws CustomerNotFoundException;
	public List<Customer> showAllCustomers(int cid);
	
}
