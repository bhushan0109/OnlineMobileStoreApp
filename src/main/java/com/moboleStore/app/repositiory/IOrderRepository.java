package com.moboleStore.app.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.entity.Orders;
import com.moboleStore.app.exception.OrderNotFoundException;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Integer> {

}
