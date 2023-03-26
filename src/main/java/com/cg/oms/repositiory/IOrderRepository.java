package com.cg.oms.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.oms.entity.Mobiles;
import com.cg.oms.entity.Orders;
import com.cg.oms.exception.OrderNotFoundException;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Integer> {
	
	@Query(value = "SELECT * FROM orders WHERE customer_id=:customerId", nativeQuery = true)
	public List<Orders> findOrderByCostomerId(int customerId);

}
