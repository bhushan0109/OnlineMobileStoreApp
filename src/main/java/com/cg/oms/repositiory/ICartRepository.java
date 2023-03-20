package com.cg.oms.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oms.entity.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {

}
