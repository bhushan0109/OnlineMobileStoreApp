package com.moboleStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moboleStore.app.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
