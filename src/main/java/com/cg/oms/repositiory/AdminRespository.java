package com.cg.oms.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oms.entity.Admin;

@Repository
public interface AdminRespository extends JpaRepository<Admin, Integer>{
  
}
