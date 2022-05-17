package com.l1nd53y.bookstore.dto.cart;

import com.l1nd53y.bookstore.model.Book;
import com.l1nd53y.bookstore.model.Cart;

public class CartItemDto {
    private Integer id;
    private Integer quantity;
    private Book book;

    public CartItemDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CartItemDto(Cart cart) {
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setBook(cart.getBook());
    }
}
