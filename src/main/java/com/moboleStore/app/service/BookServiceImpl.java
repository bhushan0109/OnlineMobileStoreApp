package com.moboleStore.app.service;
//package com.thebookStore.app.service;
//
//import java.util.List;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.thebookStore.app.entity.Books;
//
//import com.thebookStore.app.entity.Category;
//import com.thebookStore.app.exception.BooksException;
//
//import com.thebookStore.app.exception.CategoryException;
//import com.thebookStore.app.repositiory.BooksRepository;
//
//import com.thebookStore.app.repositiory.CategoryRepository;
//
///***********************************************************************************
// *         @author           Addi Srujana
// *         Description       It is a service class that provides the services for adding a new book, 
// *          				 to category, updating the book, viewing the book, getting all the books,
// *          				 and deleting a book.
// *         Version           1.0
// *         Created Date      09-FEB-2023
// ************************************************************************************/
//@Service
//public class BookServiceImpl implements BookService {
//
//	@Autowired
//	private BooksRepository booksRepository;
//
//	@Autowired
//	private CategoryRepository categoryRepository;
//	
//	/************************************************************************************
//	 * Method:-Add new book to database
//     * Description: 	    -To add a new book to database
//	 * @param Book          -Book to be added to added
//	 * @returns Books       -Book is returned after adding to database
//     * Created By           -Addi Srujana
//     * Created Date         -10-FEB-2023                          
//	 
//	 ************************************************************************************/
//	@Override
//	public Books addBooks(Books book) {
//
//		return booksRepository.save(book);
//	}
//	
//	
//	/************************************************************************************
//	 * Method:-removeBooksById
//     * Description: 	    				-To remove a book from database
//	 * @param bookId        				-Id of the book to be removed
//	 * @returns Books       				-Book is returned after adding to database
//	 * @throws BooksException  				-raised if the bookId does not exist in database
//     * Created By           -Addi Srujana
//     * Created Date         -10-FEB-2023                          
//	 
//	 ************************************************************************************/
//	@Override
//	public Books removeBooksbyId(Integer bookId) throws BooksException {
//		Optional<Books> optBooks = this.booksRepository.findById(bookId);
//		if (optBooks.isEmpty())
//			throw new BooksException("Book id " +bookId+ " does not exists to delete !");
//		Books book = optBooks.get();
//		this.booksRepository.delete(book);
//		return book;
//	}
//	
//	
//	
//	/************************************************************************************
//	 * Method:-updateBooks
//     * Description: 	    				-To update a book in database
//	 * @param BookId        				-Id of the book to be updated
//	 * @returns Books       				-Book is returned after updating to database
//	 * @throws BooksException  				-raised if the bookId does not exist in database
//     * Created By           -Addi Srujana
//     * Created Date         -10-FEB-2023                          
//	 
//	 ************************************************************************************/
//	@Override
//	public Books updateBooks(Books updateBook) throws BooksException{
//		Optional<Books> optBooks = this.booksRepository.findById(updateBook.getBookId());
//		if (optBooks.isEmpty())
//			throw new BooksException("Book id " +updateBook.getBookId()+ " does not exists to delete !");
//		
//		return booksRepository.save(updateBook);
//	}
//
//	
//	
//	/************************************************************************************
//	 * Method:-getAllBooks
//     * Description: 	    				-To get all the books in database
//	 * @returns List<Books>       			-List of all the books present in the database is returned
//     * Created By           -Addi Srujana
//     * Created Date         -10-FEB-2023                          
//	 
//	 ************************************************************************************/
//	@Override
//	public List<Books> getAllBooks() {
//
//		return booksRepository.findAll();
//	}
//	
//	
//	/************************************************************************************
//	 * Method:-getBookById
//     * Description: 	    				-To get book from database
//	 * @param BookId        				-Id of the book to be returned
//	 * @returns Books       				-Book is returned 
//	 * @throws BooksException  				-raised if the bookId does not exist in database
//     * Created By           -Addi Srujana
//     * Created Date         -10-FEB-2023                          
//	 
//	 ************************************************************************************/
//	@Override
//	public Books getBookById(Integer BookId) throws BooksException {
//		Optional<Books> optBooks = booksRepository.findById(BookId);
//		if (optBooks.isEmpty()) {
//			throw new BooksException("Boook id not found: " + BookId);
//		}
//
//		return optBooks.get();
//	}
//	
//	/************************************************************************************
//	 * Method:-addBooksToCategoryByCategoryId
//     * Description: 	    				-To add a book to category using category Id
//	 * @param Book       				    -book to be added to added
//	 * @param categoryId					-Id of the category to be added
//	 * @returns Books       				-Book is returned after adding to database
//	 * @throws CateogryException  			-raised if the categoryId does not exist in database
//     * Created By           -Addi Srujana
//     * Created Date         -10-FEB-2023                          
//	 
//	 ************************************************************************************/
//	@Override
//	public Books addBooksToCategoryByCategoryId(Books book, Integer categoryId) throws CategoryException{
//		Optional<Category> optCategory = this.categoryRepository.findById(categoryId);
//		if (optCategory.isEmpty()) {
//			throw new CategoryException("Cateogory doesn't exist for Id: " + categoryId);
//		}
//
//		Category foundCategory = optCategory.get();
//		Books newbook = this.booksRepository.save(book);
//		foundCategory.getNewBooks().add(newbook);
//		this.categoryRepository.save(foundCategory);
//		return newbook;
//	}
//	
//	/************************************************************************************
//	 * Method:-getBooksByAuthorName
//     * Description: 	    				-To get all the books written by given author in database
//     * @param bookAuthor					-name of the author
//	 * @returns List<Books>       			-List of all the books written by the given author present in the database are returned
//     * Created By           -Addi Srujana
//     * Created Date         -10-FEB-2023                          
//	 
//	 ************************************************************************************/
//	@Override
//	public List<Books> getBooksByAuthorName(String bookAuthor) throws BooksException {
//		List<Books> booksByAuthor = booksRepository.findBybookAuthor(bookAuthor);
//		if (booksByAuthor.isEmpty()) {
//			throw new BooksException("Books by author " + bookAuthor + "does not exist");
//
//		}
//		return booksByAuthor;
//	}
//
//}
