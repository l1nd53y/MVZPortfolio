package com.l1nd53y.bookstore.repository;

import antlr.Token;
import com.l1nd53y.bookstore.model.AuthToken;
import com.l1nd53y.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<AuthToken, Integer> {

    AuthToken findByUser(User user);
    AuthToken findByToken(String token);
}
