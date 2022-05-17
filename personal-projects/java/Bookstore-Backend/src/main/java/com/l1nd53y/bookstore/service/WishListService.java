package com.l1nd53y.bookstore.service;

import com.l1nd53y.bookstore.dto.BookDto;
import com.l1nd53y.bookstore.exceptions.CustomException;
import com.l1nd53y.bookstore.model.Cart;
import com.l1nd53y.bookstore.model.User;
import com.l1nd53y.bookstore.model.WishList;
import com.l1nd53y.bookstore.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishListService {

    @Autowired
    WishListRepo wishListRepo;

    @Autowired
    BookService bookService;

    public void createWishList(WishList wishList) {
        wishListRepo.save(wishList);
    }

    public List<BookDto> getWishListForUser(User user) {
        final List<WishList> wishLists = wishListRepo.findAllByUserOrderByCreatedDateDesc(user);
        List<BookDto> bookDtos = new ArrayList<>();
        for (WishList wishList: wishLists) {
            bookDtos.add(bookService.getBookDto(wishList.getBook()));

        }
        return bookDtos;

    }

    public void deleteWishListItem(Integer wishListItemId, User user) {
        //Checks if item ID belongs to user
        Optional<WishList> optionalWishList = wishListRepo.findById(wishListItemId);

        if (optionalWishList.isEmpty()) {
            throw new CustomException("Wishlist item ID is invalid: " +wishListItemId);
        }

        WishList wishList = optionalWishList.get();

        if (wishList.getUser() != user) {
            throw new CustomException("Wishlist item does not belong to user: " +wishListItemId);
        }

        wishListRepo.delete(wishList);


    }
}
