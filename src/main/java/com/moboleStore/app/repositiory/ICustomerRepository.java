package com.moboleStore.app.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moboleStore.app.entity.Customer;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.CustomerNotFoundException;


@Repository
public interface ICustomerRepository  extends JpaRepository<Customer, Integer> {

//	public Customer addCustomer(Customer Customer);
//	public Customer updateCustomer(Customer Customer) throws CustomerNotFoundException;
//	public Customer cancelCustomer(int Customerid) throws CustomerNotFoundException;
//	public List<Customer> showAllCustomers(int cid);
	
}
