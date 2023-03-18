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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Admin")
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/category/add")
	public Category addCategory(@Valid @RequestBody CategoryDto categoryDto) {
		
		return this.categoryService.createCategory(categoryDto);
	}
	@GetMapping("/category/get/all")
	public List<Category> getAllCategories(){
		return this.categoryService.getAllCategories();
	}
	
	@GetMapping("/category/get/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId")Integer categoryId)throws CategoryException  {
		return categoryService.getCategoryById(categoryId);
	}
	@DeleteMapping("/category/delete/{categoryId}")
	public Category deleteCategoryById(@PathVariable("categoryId") int CategoryId) throws CategoryException {
		return this.categoryService.deleteCategoryById(CategoryId);
	}
	@PutMapping("/category/update")
	public Category updateCategory(@Valid @RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
	@GetMapping("/category/getMobilesById/{categoryId}")
	public List<Mobiles> getMobilesByCategoryId(@PathVariable("categoryId") Integer categoryId) throws CategoryException{
		return categoryService.getMobilesByCategoryId(categoryId);
	}
	
	@GetMapping("/category/getMobilesBycatName/{categoryName}")
	public List<Mobiles> getMobilesByCategoryName(@PathVariable("categoryName") String categoryName) throws CategoryException{
		return categoryService.getMobilesByCategoryName(categoryName);
	}


}
