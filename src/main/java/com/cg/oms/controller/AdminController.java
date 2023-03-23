package com.cg.oms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oms.dto.AddUserDto;
import com.cg.oms.dto.CategoryDto;
import com.cg.oms.entity.Category;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.entity.Orders;
import com.cg.oms.exception.CategoryException;
import com.cg.oms.exception.UsersException;
import com.cg.oms.service.CategoryService;
import com.cg.oms.service.IOrderService;
import com.cg.oms.service.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
    private IUserService iUserService;
	@Autowired
	private IOrderService iOrderService;


	@PostMapping("/category/add")
	@PreAuthorize("hasAuthority('Admin')")
	public Category addCategory(@Valid @RequestBody CategoryDto categoryDto) {
		
		return this.categoryService.createCategory(categoryDto);
	}
	@GetMapping("/category/get/all")
	@PreAuthorize("hasAuthority('Admin')")
	public List<Category> getAllCategories(){
		return this.categoryService.getAllCategories();
	}
	
//	@GetMapping("/category/get/{categoryId}")
//	@PreAuthorize("hasAuthority('Admin')")
//	public Category getCategoryById(@PathVariable("categoryId")Integer categoryId)throws CategoryException  {
//		return categoryService.getCategoryById(categoryId);
//	}
	@DeleteMapping("/category/delete/{categoryId}")
	@PreAuthorize("hasAuthority('Admin')")
	public Category deleteCategoryById(@PathVariable("categoryId") int CategoryId) throws CategoryException {
		return this.categoryService.deleteCategoryById(CategoryId);
	}
	@PutMapping("/category/update")
	@PreAuthorize("hasAuthority('Admin')")
	public Category updateCategory(@Valid @RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
//	@GetMapping("/category/getMobilesById/{categoryId}")
//	@PreAuthorize("hasAuthority('Admin')")
//	public List<Mobiles> getMobilesByCategoryId(@PathVariable("categoryId") Integer categoryId) throws CategoryException{
//		return categoryService.getMobilesByCategoryId(categoryId);
//	}
	
	@GetMapping("/category/getMobilesBycatName/{categoryName}")
	@PreAuthorize("hasAuthority('Admin')")
	public List<Mobiles> getMobilesByCategoryName(@PathVariable("categoryName") String categoryName) throws CategoryException{
		return categoryService.getMobilesByCategoryName(categoryName);
	}
	@GetMapping("/allCustomer")
	@PreAuthorize("hasAuthority('Admin')")
    public List<AddUserDto> allCustomer() throws UsersException {
        return iUserService.showAllCustomer();
	}
	@GetMapping("/getAll/orders")
	@PreAuthorize("hasAuthority('Admin')")
	public List<Orders> getAllOrders() {

		return iOrderService.getAllOrders();
	}


}
