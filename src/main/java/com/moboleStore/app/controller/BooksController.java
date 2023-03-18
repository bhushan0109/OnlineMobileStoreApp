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
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.thebookStore.app.entity.Books;
//import com.thebookStore.app.exception.BooksException;
//import com.thebookStore.app.exception.CategoryException;
//import com.thebookStore.app.service.BookService;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//public class BooksController {
//	
//	@Autowired
//	private BookService bookService;
//	
//	@PostMapping("/book")
//	public Books createBook(@Valid @RequestBody Books book) {
//	
//		return bookService.addBooks(book);
//	}
//	
//	@DeleteMapping("/book/{id}")
//	public Books deleteBooksbyId(@PathVariable("id") Integer BookId) throws BooksException{
//		return bookService.removeBooksbyId(BookId);
//	}
//	
//	@PutMapping("/book")
//	public Books modifyBook(@Valid @RequestBody Books book) throws BooksException {
//		return bookService.updateBooks(book);
//	}
//	
//	@GetMapping("/books")
//	public List<Books> getBooks() {
//		return bookService.getAllBooks();
//		
//	}
//	
//	@GetMapping("/book/{id}")
//	public Books getBookById(@PathVariable("id") Integer bookId) throws BooksException{
//		return bookService.getBookById(bookId);
//	}
//	
//	@PostMapping("/books/{id}")
//	public  Books addBooksToCategoryByCategoryId(@PathVariable("id") Integer categoryId, @Valid @RequestBody Books book) throws CategoryException {
//		return bookService.addBooksToCategoryByCategoryId(book, categoryId);
//	}
//	
//	@GetMapping("/books/{authorName}")
//	public List<Books> getBooksByAuthorName(@Valid @RequestParam String authorName) throws BooksException{
//		return bookService.getBooksByAuthorName(authorName);
//	}
//			
//}
