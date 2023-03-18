package com.moboleStore.app.service;
import java.util.List;

import javax.validation.Valid;

import com.moboleStore.app.dto.CategoryDto;
import com.moboleStore.app.entity.Category;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.CategoryException;


public interface CategoryService {

	public Category createCategory(@Valid CategoryDto categoryDto);

	public List<Category> getAllCategories();

	public Category getCategoryById(Integer CategoryId) throws CategoryException;

	public Category updateCategory(Category updateCategory);

	public List<Mobiles> getMobilesByCategoryId(Integer categoryId) throws CategoryException;

	public Category deleteCategoryById(Integer categoryId) throws CategoryException;
	
	public Mobiles deleteMobilesFromCategoryById(Integer categoryId ,Integer MobileId) throws CategoryException;

	public List<String> getAllCategoriesName();
}
