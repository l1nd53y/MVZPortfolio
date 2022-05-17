package com.l1nd53y.bookstore.controller;

import com.l1nd53y.bookstore.dto.checkout.CheckoutBookDto;
import com.l1nd53y.bookstore.dto.checkout.StripeResponse;
import com.l1nd53y.bookstore.service.AuthService;
import com.l1nd53y.bookstore.service.OrderService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private AuthService authService;

    @Autowired
    private OrderService orderService;

    //Stripe session checkout API
    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutBookDto> checkoutBookDtoList)
            throws StripeException {
        Session session = orderService.createSession(checkoutBookDtoList);
        StripeResponse stripeResponse = new StripeResponse(session.getId());
        return new ResponseEntity<>(stripeResponse, HttpStatus.OK);

    }
}

