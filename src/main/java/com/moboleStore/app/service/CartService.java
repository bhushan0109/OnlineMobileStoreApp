package com.moboleStore.app.service;
//package com.thebookStore.app.service;
//
//
//
//import java.util.List;
//
//import com.thebookStore.app.entity.Books;
//import com.thebookStore.app.entity.Cart;
//import com.thebookStore.app.exception.BooksException;
//import com.thebookStore.app.exception.CartException;
//import com.thebookStore.app.exception.UsersException;
//
//
//public interface CartService {
//	public Cart addBookToCartByUserId(Integer bookId, Integer userId) throws BooksException, UsersException, CartException;
//
//	public Cart updateCart(Cart cart) throws CartException;
//
//	public Cart deleteCartById(Integer Id) throws CartException;
//
//	public Cart getCartById(Integer userId) throws CartException, UsersException;
//	
//	public Books removeBookfromCartByIds(Integer bookId, Integer cartId) throws CartException;
//	
//	public List<Cart> getAllCarts();
//	
//	//calculate the total number of books in the cart
//	//calculate the total cost in the cart
//}
