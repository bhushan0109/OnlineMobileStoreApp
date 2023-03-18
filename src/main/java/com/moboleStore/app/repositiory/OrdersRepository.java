package com.moboleStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moboleStore.app.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
