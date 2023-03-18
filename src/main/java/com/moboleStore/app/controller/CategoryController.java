package com.moboleStore.app.controller;
//package com.thebookStore.app.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.thebookStore.app.entity.Books;
//import com.thebookStore.app.entity.Category;
//import com.thebookStore.app.exception.CategoryException;
//import com.thebookStore.app.service.CategoryService;
//@CrossOrigin(origins = "http://localhost:4200/")
//@RestController
//public class CategoryController {
//	
//	@Autowired
//	private CategoryService categoryService;
//	
//	
//	
//	@PostMapping("/category")
//	public Category addCategory(@Valid @RequestBody Category category) {
//		
//		return this.categoryService.createCategory(category);
//	}
//	@GetMapping("categories")
//	public List<Category> getAllCategories(){
//		return this.categoryService.getAllCategories();
//	}
//	
//	@GetMapping("/category/{id}")
//	public Category getCategoryById(@PathVariable("id")Integer categoryId)throws CategoryException  {
//		return categoryService.getCategoryById(categoryId);
//	}
//	@DeleteMapping("/category/{id}")
//	public Category deleteCategoryById(@PathVariable("id") int CategoryId) throws CategoryException {
//		return this.categoryService.deleteCategoryById(CategoryId);
//	}
//	@PutMapping("/category")
//	public Category updateCategory(@Valid @RequestBody Category category) {
//		return categoryService.updateCategory(category);
//	}
//	@GetMapping("/booksincategory/{id}")
//	public List<Books> getBooksByCategoryId(@PathVariable("id") Integer categoryId) throws CategoryException{
//		return categoryService.getBooksByCategoryId(categoryId);
//	}
//	
//	@DeleteMapping("/book/{categoryid}")
//	public Books deleteBooksbyCategoryId(@PathVariable("categoryid") Integer categoryId, Integer bookId) throws CategoryException{
//		return categoryService.deleteBookFromCategoryById(bookId, categoryId);
//	}
//	
//
//}
