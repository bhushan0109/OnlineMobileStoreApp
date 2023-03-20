package com.cg.oms.service;
import java.util.List;

import javax.validation.Valid;

import com.cg.oms.dto.CategoryDto;
import com.cg.oms.entity.Category;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.exception.CategoryException;


public interface CategoryService {

	public Category createCategory(@Valid CategoryDto categoryDto);

	public List<Category> getAllCategories();

	public Category getCategoryById(int CategoryId) throws CategoryException;

	public Category updateCategory(Category updateCategory);

	public List<Mobiles> getMobilesByCategoryId(int categoryId) throws CategoryException;

	public Category deleteCategoryById(int categoryId) throws CategoryException;
	
	public List<String> getAllCategoriesName();

	public List<Mobiles> getMobilesByCategoryName(String categoryName) throws CategoryException;
}
