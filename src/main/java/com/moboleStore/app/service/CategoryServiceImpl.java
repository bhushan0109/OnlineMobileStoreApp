package com.moboleStore.app.service;
//package com.thebookStore.app.service;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.thebookStore.app.entity.Books;
//import com.thebookStore.app.entity.Category;
//import com.thebookStore.app.exception.CategoryException;
//import com.thebookStore.app.repositiory.BooksRepository;
//import com.thebookStore.app.repositiory.CategoryRepository;
//
//
///************************************************************************************
// * @author Mahitha 
// * Description :It is a service class that provides the services
// *               for addCategories, deleteCategoryById,getAllCategories,getCategoryById,updateCategory  
// *         
// * Version 1.0
// *  Created Date 08-FEB-2023
// ************************************************************************************/
//@Service
//public class CategoryServiceImpl implements CategoryService{
//
//	
//	
//	@Autowired
//	private BooksRepository booksRepository;
//	@Autowired
//	private CategoryRepository categoryRepository;
//	
//	
//	/************************************************************************************
//	 * Method: - createCategory Description: - To add Category
//	 * 
//	 * @param category - categoryId
//	 * 
//	 * 
//	 * @returns - returns the saved entity
//	 *
//	 * Created By - Mahitha 
//	 * Created Date - 8-FEB-2023
//	 * 
//	 ************************************************************************************/
//	@Override
//	public Category createCategory(Category category) {
//		
//		return categoryRepository.save(category);
//	}
//	
//	
//	/************************************************************************************
//	 * Method: - getAllCategories 
//	 * Description: - To getAllCategories
//	 * 
//	 * @param categoryId - categoryId
//	 * 
//	 * 
//	 * @returns Boolean - findAll Categories
//	 *
//	 * Created By - Mahitha
//	 * Created Date - 8-FEB-2023
//	 * 
//	 ************************************************************************************/
////	@Override
////	public List<String> getAllCategories() {
////		List<String> categoryNames= new ArrayList<>(); 
////		List<Category> optCategories = this.categoryRepository.findAll();
////		for (Iterator<Category> iterator = optCategories.iterator(); iterator.hasNext();) {
////			Category category = (Category) iterator.next();
////			categoryNames.add(category.getCategoryName());
////			
////		}
////		return categoryNames;
////		
////	}
//	
//	
//	/************************************************************************************
//	 * Method: - getCategoryById
//	 * Description: -To getCategorybyId
//	 * 
//	 * 
//	 * @param - CategoryId
//	 * 
//	 * @returns - if categoryId exists returns categories object
//	 * @throws AccountException - It is raised for Invalid categoryId
//	 * 
//	 * 
//	 *  Created By - Mahitha 
//	 *  Created Date - 8-Feb-2023
//	 * 
//	 ************************************************************************************/
//
//	@Override
//	public Category getCategoryById(Integer CategoryId) throws CategoryException{
//		Optional<Category> optCategories = categoryRepository.findById(CategoryId);
//		if(optCategories.isEmpty()) {
//			throw new CategoryException("Category id is not found: " +CategoryId);
//		}
//		return optCategories.get();
//	}
//	
//	
//	/************************************************************************************
//	 * Method: - deleteCategoryById
//	 * Description: -To deleteCategorybyId
//	 * 
//	 * 
//	 * @param - CategoryId
//	 * 
//	 * @returns - if categoryId exists  returns category object
//	 * @throws AccountException - It is raised for Invalid categoryId
//	 * 
//	 * 
//	 *  Created By - Mahitha 
//	 *  Created Date - 8-Feb-2023
//	 * 
//	 ************************************************************************************/
//	@Override
//	public Category deleteCategoryById(Integer categoryId) throws CategoryException{
//		Optional<Category> optCategories = this.categoryRepository.findById(categoryId);
//		if(optCategories.isEmpty())
//			throw new CategoryException("Category id does not exists to delete ");
//		Category category = optCategories.get();
//		this.categoryRepository.delete(category);
//		return category;
//	}
//	
//
//	/************************************************************************************
//	 * Method: - updateCategory Description: -To updateCategory
//	 * 
//	 * @param categoryId - update categoryId
//	 * 
//	 * 
//	 * @returns - returns the updated category
//	 *
//	 *          Created By - Mahitha Created Date - 8-FEB-2023
//	 * 
//	 ************************************************************************************/
//	@Override
//	public Category updateCategory(Category updateCategory) {
//		return categoryRepository.save(updateCategory);
//		
//	}
//	
//	
//	/************************************************************************************
//	 * Method: - getBooks By CategoryId
//	 * Description: -To getBooks By CategoryId
//	 * 
//	 * 
//	 * @param - CategoryId
//	 * 
//	 * @returns - if categoryId exists  returns Books object
//	 * @throws AccountException - It is raised for Invalid categoryId
//	 * 
//	 * 
//	 *  Created By - Mahitha 
//	 *  Created Date - 8-Feb-2023
//	 * 
//	 ************************************************************************************/
//	@Override
//	public List<Books> getBooksByCategoryId(Integer categoryId) throws CategoryException{
//		Optional<Category> optCategories = this.categoryRepository.findById(categoryId);
//		if(optCategories.isEmpty())
//			throw new CategoryException("Category id does not exists to delete ");
//		Category foundCategory = optCategories.get();
//		return foundCategory.getNewBooks();
//	}
//	
//	
//	/************************************************************************************
//	 * Method: - deleteBooks From Category By CategoryId
//	 * Description: -To deleteBooks By CategoryId
//	 * 
//	 * 
//	 * @param - CategoryId
//	 * 
//	 * @returns - if categoryId exists  returns Books object
//	 * @throws AccountException - It is raised for Invalid categoryId
//	 * 
//	 * 
//	 *  Created By - Mahitha 
//	 *  Created Date - 8-Feb-2023
//	 * 
//	 ************************************************************************************/
//	@Override
//	public Books deleteBookFromCategoryById(Integer bookId, Integer categoryId) throws CategoryException {
//		Optional<Category> optCategory = this.categoryRepository.findById(categoryId);
//		if(optCategory.isEmpty()) {
//			throw new CategoryException("Cateogory doesn't exist for Id: "+categoryId);
//		}
//		Category foundCategory = optCategory.get();
//		Optional<Books> optBook = booksRepository.findById(bookId);
//		Books delBook = optBook.get();
//		List<Books> books = foundCategory.getNewBooks();
//		books.remove(delBook);
//		foundCategory.setNewBooks(books);
//		booksRepository.delete(delBook);
//		return delBook;
//	}
//
//
//	@Override
//	public List<Category> getAllCategories() {
//		
//		return this.categoryRepository.findAll();
//	}
//
//	
//	
//
//
//
//}
