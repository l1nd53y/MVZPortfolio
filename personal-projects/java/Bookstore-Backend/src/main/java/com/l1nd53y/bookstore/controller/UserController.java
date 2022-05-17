package com.l1nd53y.bookstore.controller;

import com.l1nd53y.bookstore.dto.ResponseDto;
import com.l1nd53y.bookstore.dto.user.SignInDto;
import com.l1nd53y.bookstore.dto.user.SignInResponseDto;
import com.l1nd53y.bookstore.dto.user.SignupDto;
import com.l1nd53y.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    //Two APIs


    //Sign-up
    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return userService.signUp(signupDto);
    }


    //Sign-in
    @PostMapping("/signin")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }
}
