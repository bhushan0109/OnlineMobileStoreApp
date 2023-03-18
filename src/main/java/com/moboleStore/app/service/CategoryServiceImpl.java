package com.moboleStore.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moboleStore.app.dto.CategoryDto;
import com.moboleStore.app.entity.Category;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.CategoryException;
import com.moboleStore.app.repositiory.CategoryRepository;
import com.moboleStore.app.repositiory.IMobileRepository;

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
	public Category getCategoryById(Integer CategoryId) throws CategoryException {
		Optional<Category> optCategories = categoryRepository.findById(CategoryId);
		if (optCategories.isEmpty()) {
			throw new CategoryException("Category id is not found: " + CategoryId);
		}
		return optCategories.get();
	}

	@Override
	public Category deleteCategoryById(Integer categoryId) throws CategoryException {
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
	public List<Mobiles> getMobilesByCategoryId(Integer categoryId) throws CategoryException {

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
	public Mobiles deleteMobilesFromCategoryById(Integer categoryId, Integer MobileId) throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

}
