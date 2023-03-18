package com.moboleStore.app.service;
//package com.thebookStore.app.service;
//
//
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.thebookStore.app.entity.Books;
//import com.thebookStore.app.entity.Cart;
//import com.thebookStore.app.entity.Users;
//import com.thebookStore.app.exception.BooksException;
//import com.thebookStore.app.exception.CartException;
//import com.thebookStore.app.exception.UsersException;
//import com.thebookStore.app.repositiory.BooksRepository;
//import com.thebookStore.app.repositiory.CartRepository;
//import com.thebookStore.app.repositiory.UsersRepository;
//
///***********************************************************************************
//
// * @author RajamReddy Greeshma
// * Description It is a service class that provides the services for adding a new book, 
// * to category, updating the user id, getting all the books,
// * and deleting a book.
// * Version 1.0
// * Created Date 09-FEB-2023
//
// ************************************************************************************/
//@Service
//public class CartServiceImpl implements CartService{
//	@Autowired
//	private CartRepository cartRepository;
//	@Autowired
//	private BooksRepository booksRepository;
//	@Autowired
//	private UsersRepository usersRepository;
//	
//	
//	@Autowired 
//	private BookService bookService;
//	
//	@Autowired
//	private UserService userService;
//
//	
//
//	/************************************************************************************
//	 
//	 * Method:-addBooksToCartByUserId
//	 * Description: -To add a book to cart using User Id
//	 * @param Book -book to be added to added
//	 * @param user Id -Id of the User to be added
//	 * @returns Books -Book is returned after adding to database
//	 * @throws CartException,BookException,UsersException -raised if the UserId does not exist in database
//	 * Created By -RajamReddy Greeshma
//	 * Created Date -10-FEB-2023 	 
//	 * 
//	 ************************************************************************************/
//	@Override
//	public Cart updateCart(Cart cart) throws CartException {
//		Optional<Cart> optCarts = cartRepository.findById(cart.getCartId());
//		if(optCarts.isEmpty()) {
//			throw new CartException("Cart id not found:" +cart.getCartId());
//		}
//		return cartRepository.save(cart);
//	}
//	
//	
//	/************************************************************************************
//	 * Method:-Delete new Cart by cartId
//	 * Description: -To delete a new cartId to database
//	 * @param Cart -Cart to be delete the id
//	 * @returns Cart -delete is returned after adding to database
//	 * Created By -RajamReddy Greeshma
//	 * Created Date -10-FEB-2023 
//
//	 ************************************************************************************/
//	@Override
//	public Cart deleteCartById(Integer Id) throws  CartException{
//		Optional<Cart> optCarts = this.cartRepository.findById(Id);
//		if (optCarts.isEmpty())
//			throw new CartException("Customer id is not exists to delete !");
//		Cart cart = optCarts.get();
//		this.cartRepository.delete(cart);
//		
//		return cart;
//	}
//
//	
//	/************************************************************************************
//	 
//	 * Method:-getCartById
//	 * Description: -To get Cart from database
//	 * @param Cart Id -Id of the book to be returned
//	 * @returns Carts -id is returned 
//	 * @throws BooksException -raised if the Cart Id does not exist in database
//	 * Created By -RajamReddy Greeshma
//	 * Created Date -10-FEB-2023 
//
//	 ************************************************************************************/
//	@Override
//	public Cart getCartById(Integer userId) throws UsersException  {
//		Optional<Users> optUser = usersRepository.findById(userId);
//		if(optUser.isEmpty()) {
//			throw new UsersException("User id not found:" +userId);
//		}
//		
//		return optUser.get().getCart() ;
//	}
//
//	
//	
//		    
//
//
//
//	/************************************************************************************
//			 
//		* Method:-removeBookfromCartByIds
//		* Description: -To remove a bookfromCartById from database
//		* @parambookId -Id of the book to be removed
//		* @returns Books -Book is returned after adding to database
//		* @throws BooksException -raised if the bookId does not exist in database
//		* Created By -RajamReddy Greeshma
//		* Created Date -10-FEB-2023 
//
//	 **********************************************************************************/
//
//	@Override
//	public Books removeBookfromCartByIds(Integer bookId, Integer cartId) throws CartException{
//		Optional<Cart> optCart = this.cartRepository.findById(cartId);
//		if(optCart.isEmpty())
//			throw new CartException("Category id does not exists to delete ");
//		
//		Cart foundCart = optCart.get();
//		Optional<Books> optBook = booksRepository.findById(bookId);
//		Books delBook = optBook.get();
//		
//		List<Books> books = foundCart.getBooksInCart();
//		books.remove(delBook);
//		
//		foundCart.setBooksInCart(books);
//		Integer quantity = foundCart.getQuantity();
//		quantity = quantity-1;
//		
//		foundCart.setQuantity(quantity);
//		Float cost = foundCart.getTotalCost() - delBook.getPrice();
//		foundCart.setTotalCost(cost);
//		return delBook;
//	}
//
//	
//
//	
//
//	/************************************************************************************
//	 
//	 * Method:-getAllCarts
//	 * Description: -To get all the Carts written by given author in database
//	 * @param bookAuthor -name of the author
//	 * @returns List<Books> -List of all the books written by the given author present in the database are returned
//	 * Created By -RajamReddy Greeshma
//	 * Created Date -10-FEB-2023  
//
//	 ************************************************************************************/
//	@Override
//	public List<Cart> getAllCarts() {
//		
//		return cartRepository.findAll();
//	}
//
//	
//	/************************************************************************************
//	 
//	 * Method:-addBooksToCartByUserId
//	 * Description: -To add a book to cart using User Id
//	 * @param Book -book to be added to added
//	 * @param user Id -Id of the User to be added
//	 * @returns Books -Book is returned after adding to database
//	 * @throws CartException,BookException,UsersException -raised if the UserId does not exist in database
//	 * Created By -RajamReddy Greeshma
//	 * Created Date -10-FEB-2023 	 
//	 * 
//	 ************************************************************************************/
//	@Override
//	public Cart addBookToCartByUserId(Integer bookId, Integer userId)
//			throws BooksException, UsersException, CartException {
//		Users user = userService.getUserByUserId(userId); 
//		
//		Cart cart = user.getCart();
//		
//		Books book = bookService.getBookById(bookId);
//		
//		if(cart == null) {
//			cart = new Cart();
//			cart.setBooksInCart(new ArrayList<>());
//			cart.getBooksInCart().add(book);
//			
//			cart= this.cartRepository.save(cart);
////			Integer total = cart.getQuantity();
////			total++;
//			cart.setQuantity(1);
////			Float cost = cart.getTotalCost() + book.getPrice();
//			cart.setTotalCost(book.getPrice());
//			
//			
//			user.setCart(cart);
//		}
//		else {
//			cart = user.getCart();
//			cart.getBooksInCart().add(book);
//			cart= this.cartRepository.save(cart);
//			Integer total = cart.getQuantity();
//			total++;
//			cart.setQuantity(total);
//			Float cost = cart.getTotalCost() + book.getPrice();
//			cart.setTotalCost(cost);
//			user.setCart(cart);
//		}
//
//		return this.cartRepository.save(cart);
//	}
//	
//	
//
//	
//	
//}
//
//
//
