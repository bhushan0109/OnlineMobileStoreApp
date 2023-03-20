package com.cg.oms.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.oms.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	@Query(value = "SELECT * FROM category WHERE category_name=:categoryName", nativeQuery = true)
	Category findByCategoryName(String categoryName);

}
