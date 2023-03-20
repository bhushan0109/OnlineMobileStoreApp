package com.cg.oms.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oms.entity.Customer;
import com.cg.oms.entity.Users;
import com.cg.oms.exception.CustomerNotFoundException;


@Repository
public interface ICustomerRepository  extends JpaRepository<Customer, Integer> {
	
}
