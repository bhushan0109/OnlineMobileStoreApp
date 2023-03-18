package com.moboleStore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moboleStore.app.dto.CategoryDto;
import com.moboleStore.app.entity.Category;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.CategoryException;
import com.moboleStore.app.service.CategoryService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/add")
	public Category addCategory(@Valid @RequestBody CategoryDto categoryDto) {
		
		return this.categoryService.createCategory(categoryDto);
	}
	@GetMapping("get/all")
	public List<Category> getAllCategories(){
		return this.categoryService.getAllCategories();
	}
	
	@GetMapping("/get/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId")Integer categoryId)throws CategoryException  {
		return categoryService.getCategoryById(categoryId);
	}
	@DeleteMapping("/delete/{categoryId}")
	public Category deleteCategoryById(@PathVariable("categoryId") int CategoryId) throws CategoryException {
		return this.categoryService.deleteCategoryById(CategoryId);
	}
	@PutMapping("/update")
	public Category updateCategory(@Valid @RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
	@GetMapping("/getMobilesBy/{categoryId}")
	public List<Mobiles> getMobilesByCategoryId(@PathVariable("categoryId") Integer categoryId) throws CategoryException{
		return categoryService.getMobilesByCategoryId(categoryId);
	}
	
}
