package com.l1nd53y.bookstore.repository;

import com.l1nd53y.bookstore.model.Cart;
import com.l1nd53y.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

}
