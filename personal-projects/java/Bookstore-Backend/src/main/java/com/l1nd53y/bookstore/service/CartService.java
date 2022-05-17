package com.l1nd53y.bookstore.service;

import com.l1nd53y.bookstore.dto.cart.AddToCartDto;
import com.l1nd53y.bookstore.dto.cart.CartDto;
import com.l1nd53y.bookstore.dto.cart.CartItemDto;
import com.l1nd53y.bookstore.exceptions.CustomException;
import com.l1nd53y.bookstore.model.Book;
import com.l1nd53y.bookstore.model.Cart;
import com.l1nd53y.bookstore.model.User;
import com.l1nd53y.bookstore.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    BookService bookService;

    @Autowired
    CartRepo cartRepo;

    public void addToCart(AddToCartDto addToCartDto, User user) {

        //Validate book id
        Book book = bookService.findById(addToCartDto.getBookId());

        Cart cart = new Cart();
        cart.setBook(book);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());

        //Save cart
        cartRepo.save(cart);

        //
    }

    public CartDto listCartItems(User user) {
        List<Cart> cartList = cartRepo.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        double totalCost = 0;
        for (Cart cart: cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCost += cartItemDto.getQuantity() * cart.getBook().getPrice();
            cartItems.add(cartItemDto);
        }

        CartDto cartDto = new CartDto();
        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems (cartItems);
        return cartDto;

    }

    public void deleteCartItem(Integer cartItemId, User user) {
        //Checks if item ID belongs to user

        Optional<Cart> optionalCart = cartRepo.findById(cartItemId);

        if (optionalCart.isEmpty()) {
            throw new CustomException("Cart item ID is invalid: " + cartItemId);
        }

        Cart cart = optionalCart.get();

        if (cart.getUser() != user) {
            throw  new CustomException("Cart item does not belong to user: " +cartItemId);
        }

        cartRepo.delete(cart);


    }
}
