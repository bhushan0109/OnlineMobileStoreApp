package com.cg.oms.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oms.entity.Mobiles;
import com.cg.oms.entity.Orders;
import com.cg.oms.exception.OrderNotFoundException;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Integer> {

}
