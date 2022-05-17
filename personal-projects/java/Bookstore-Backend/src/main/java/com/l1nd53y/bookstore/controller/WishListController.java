package com.l1nd53y.bookstore.controller;

import com.l1nd53y.bookstore.common.ApiResponse;
import com.l1nd53y.bookstore.dto.BookDto;
import com.l1nd53y.bookstore.model.Book;
import com.l1nd53y.bookstore.model.User;
import com.l1nd53y.bookstore.model.WishList;
import com.l1nd53y.bookstore.service.AuthService;
import com.l1nd53y.bookstore.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    WishListService wishListService;

    @Autowired
    AuthService authService;

    //Save book to wishlist
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToWishList(@RequestBody Book book,
                                                     @RequestParam("token") String token) {
        //Authenticate the token
        authService.authenticate(token);

        //Find the user
        User user = authService.getUser(token);

        //Save book to wishlist
        WishList wishList = new WishList(user, book);
        wishListService.createWishList(wishList);
        ApiResponse apiResponse = new ApiResponse(true, "Added to wishlist!");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    //Get all wishlist items for user
    @GetMapping("/{token}")
    public ResponseEntity<List<BookDto>> getWishList(@PathVariable("token") String token) {

        //Authenticate the token
        authService.authenticate(token);

        //Find the user
        User user = authService.getUser(token);

        //Get items
        List<BookDto> bookDtos = wishListService.getWishListForUser(user);
        return new ResponseEntity<>(bookDtos, HttpStatus.OK);
    }

    //DELETE wishlist item
    @DeleteMapping("/delete/{wishListItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("wishListItemId") Integer itemId,
                                                      @RequestParam("token") String token) {
        //Authenticate the token
        authService.authenticate(token);

        //Find the user
        User user = authService.getUser(token);

        //Delete item
        wishListService.deleteWishListItem(itemId, user);
        return new ResponseEntity<>(new ApiResponse(true, "Item successfully removed from wishlist"), HttpStatus.OK);
    }


}
