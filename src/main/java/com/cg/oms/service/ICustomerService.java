package com.cg.oms.service;


import java.util.List;

import com.cg.oms.entity.Customer;
import com.cg.oms.exception.CustomerNotFoundException;



public interface ICustomerService {

	public Customer addCustomer(Customer Customer);
	public Customer updateCustomer(Customer Customer) throws CustomerNotFoundException;
	public Customer cancelCustomer(int Customerid) throws CustomerNotFoundException;
	public List<Customer> showAllCustomers(int cid);
}
