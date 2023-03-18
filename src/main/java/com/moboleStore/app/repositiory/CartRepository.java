package com.moboleStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moboleStore.app.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
