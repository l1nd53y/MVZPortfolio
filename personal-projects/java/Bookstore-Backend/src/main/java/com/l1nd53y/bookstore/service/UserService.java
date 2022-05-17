package com.l1nd53y.bookstore.service;

import com.l1nd53y.bookstore.dto.ResponseDto;
import com.l1nd53y.bookstore.dto.user.SignInDto;
import com.l1nd53y.bookstore.dto.user.SignInResponseDto;
import com.l1nd53y.bookstore.dto.user.SignupDto;
import com.l1nd53y.bookstore.exceptions.AuthFailException;
import com.l1nd53y.bookstore.exceptions.CustomException;
import com.l1nd53y.bookstore.model.AuthToken;
import com.l1nd53y.bookstore.model.User;
import com.l1nd53y.bookstore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthService authService;

    @Transactional

    public ResponseDto signUp(SignupDto signupDto) {
        //Check User Duplicate
        if (Objects.nonNull(userRepo.findByEmail(signupDto.getEmail()))) {
            // We have a user
            throw new CustomException("This user already exists!");
        }

        //Hash Password
        String encryptedPassword = signupDto.getPassword();
        try {
            encryptedPassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();


        }

        //Save User
        User user = new User(signupDto.getFirstName(), signupDto.getLastName(),
                signupDto.getEmail(), encryptedPassword);
        userRepo.save(user);

        //Create Token

        final AuthToken authToken = new AuthToken(user);

        authService.saveConfirmationToken(authToken);

        ResponseDto responseDto = new ResponseDto("success", "User was successfully created!");
        return responseDto;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInResponseDto signIn(SignInDto signInDto) {
        //Find user by email
        User user = userRepo.findByEmail(signInDto.getEmail());

        if (Objects.isNull(user)) {
            throw new AuthFailException("Invalid user!");
        }

        //Hash the password

        try {
            if (!user.getPassword ().equals(hashPassword(signInDto.getPassword()))) {
                throw new AuthFailException("Invalid password!" );
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //Compare password with DB

        //If password matches

        AuthToken token = authService.getToken(user);

        //Retrieve token
        if (Objects.isNull(token)) {
            throw new CustomException("Token does not exist!");
        }
        return new SignInResponseDto( "Success", token.getToken());

        //Return response
    }
}
