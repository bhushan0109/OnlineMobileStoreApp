package com.cg.oms.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.dto.CategoryDto;
import com.cg.oms.entity.Category;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.exception.CategoryException;
import com.cg.oms.repositiory.CategoryRepository;
import com.cg.oms.repositiory.IMobileRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private IMobileRepository iMobileRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryName(categoryDto.getCategoryName());
		return categoryRepository.save(category);
	}

	@Override
	public List<String> getAllCategoriesName() {
		List<String> categoryNames = new ArrayList<>();
		List<Category> optCategories = this.categoryRepository.findAll();
		for (Iterator<Category> iterator = optCategories.iterator(); iterator.hasNext();) {
			Category category = (Category) iterator.next();
			categoryNames.add(category.getCategoryName());

		}
		return categoryNames;

	}

	@Override
	public Category getCategoryById(int CategoryId) throws CategoryException {
		Optional<Category> optCategories = categoryRepository.findById(CategoryId);
		if (optCategories.isEmpty()) {
			throw new CategoryException("Category id is not found: " + CategoryId);
		}
		return optCategories.get();
	}

	@Override
	public Category deleteCategoryById(int categoryId) throws CategoryException {
		Optional<Category> optCategories = this.categoryRepository.findById(categoryId);
		if (optCategories.isEmpty())
			throw new CategoryException("Category id does not exists to delete ");
		Category category = optCategories.get();
		this.categoryRepository.delete(category);
		return category;
	}

	@Override
	public Category updateCategory(Category updateCategory) {
		return categoryRepository.save(updateCategory);

	}

	@Override
	public List<Mobiles> getMobilesByCategoryId(int categoryId) throws CategoryException {

		Optional<Category> optCategories = this.categoryRepository.findById(categoryId);
		if (optCategories.isEmpty())
			throw new CategoryException("Category id does not exists to delete ");

		List<Mobiles> list = iMobileRepository.findbyCategory(optCategories.get().getCategoryId());
		return list;
	}


	@Override
	public List<Category> getAllCategories() {

		return this.categoryRepository.findAll();
	}

	@Override
	public List<Mobiles> getMobilesByCategoryName(String categoryName) throws CategoryException {
		
		Category findByCategoryName = categoryRepository.findByCategoryName(categoryName);
		
		if (findByCategoryName == null) {
			throw new CategoryException("CategoryName " + categoryName + " not exists !");

		}
		Integer categoryId = findByCategoryName.getCategoryId();	
		List<Mobiles> findbyCategoryList = iMobileRepository.findbyCategory(categoryId);
		
		return findbyCategoryList;
	}

}
