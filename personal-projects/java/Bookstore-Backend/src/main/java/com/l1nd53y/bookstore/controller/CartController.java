package com.l1nd53y.bookstore.controller;

import com.l1nd53y.bookstore.common.ApiResponse;
import com.l1nd53y.bookstore.dto.cart.AddToCartDto;
import com.l1nd53y.bookstore.dto.cart.CartDto;
import com.l1nd53y.bookstore.model.Book;
import com.l1nd53y.bookstore.model.User;
import com.l1nd53y.bookstore.service.AuthService;
import com.l1nd53y.bookstore.service.BookService;
import com.l1nd53y.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private AuthService authService;

    //POST cart
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
                                                 @RequestParam("token") String token) {
        //Authenticate the token
        authService.authenticate(token);

        //Find the user
        User user = authService.getUser(token);

        //Add item(s)
        cartService.addToCart(addToCartDto, user);
        return new ResponseEntity<>(new ApiResponse(true, "Added to cart!"), HttpStatus.CREATED);

    }

    //GET cart
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {

        //Authenticate the token
        authService.authenticate(token);

        //Find the user
        User user = authService.getUser(token);

        //Get the cart items
        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    //DELETE cart item
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId,
                                                      @RequestParam("token") String token) {
        //Authenticate the token
        authService.authenticate(token);

        //Find the user
        User user = authService.getUser(token);

        //Delete item
        cartService.deleteCartItem(itemId, user);
        return new ResponseEntity<>(new ApiResponse(true, "Item successfully removed from cart"), HttpStatus.OK);
    }


}
