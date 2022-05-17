package com.l1nd53y.bookstore.service;

import antlr.Token;
import com.l1nd53y.bookstore.exceptions.AuthFailException;
import com.l1nd53y.bookstore.model.AuthToken;
import com.l1nd53y.bookstore.model.User;
import com.l1nd53y.bookstore.repository.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    TokenRepo tokenRepo;
    public void saveConfirmationToken(AuthToken authToken) {
        tokenRepo.save(authToken);
    }

    public AuthToken getToken(User user) {
        return tokenRepo.findByUser(user);
    }

    public User getUser(String token) {
        final AuthToken authToken = tokenRepo.findByToken(token);
        if(Objects.isNull(authToken)) {
            return null;
        }
        //AuthToken is not null
        return authToken.getUser();

    }

    public void authenticate(String token) throws AuthFailException {
        //Null check
        if(Objects.isNull(token)) {
            throw new AuthFailException("Token does not exist!");
        }
        if(Objects.isNull(getUser(token))) {
            throw new AuthFailException("Invalid token!");

        }
    }
}
