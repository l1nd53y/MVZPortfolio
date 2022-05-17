package com.l1nd53y.bookstore.exceptions;

public class AuthFailException extends IllegalArgumentException {

    public AuthFailException(String msg) {
        super(msg);
    }
}
