package com.moboleStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moboleStore.app.entity.Admin;

@Repository
public interface AdminRespository extends JpaRepository<Admin, Integer>{
}
