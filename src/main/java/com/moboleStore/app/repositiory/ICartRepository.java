package com.moboleStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moboleStore.app.entity.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {

}
