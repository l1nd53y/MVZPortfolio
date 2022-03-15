package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Status;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Hasher;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@CrossOrigin("*") //Cross-origin resource sharing (CORS) "allows you to specify in a flexible way what kind of cross domain requests are authorized"
@RestController // "Every request handling method of the controller class automatically serializes return objects into HttpResponse"
@RequestMapping("/api/users") // Used to map web requests to Spring Controller methods
public class UserController {

    @Autowired // allows Spring to resolve and inject collaborating beans into our bean
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping // Annotation for mapping HTTP GET requests onto specific handler methods
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // build create user REST API
    @PostMapping("/register") // Annotation for mapping HTTP POST requests onto specific handler methods
    public Status createUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();
        for(User user :users) {
            if (user.equals(newUser)) {
                System.out.println("User already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        this.userService.save(newUser);
        return Status.SUCCESS;
    }
    @PutMapping("/login")
    public Status loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (user.getUsername().equals(other.getUsername())) {
                System.out.println("Username: " + other.getUsername() +" found");
                System.out.println("checking password");
              if(encoder().matches(user.getPassword(), other.getPassword())) {
                  System.out.println("Other password is " + other.getPassword());
                  System.out.println("password matches");

                  other.setLoggedIn(true);

                userRepository.save(other);
                return Status.SUCCESS;}
            }
        }        return Status.FAILURE;
    }
    @PostMapping("/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
               // userRepository.save(user);
                return Status.SUCCESS;
            }
        }        return Status.FAILURE;
    }

    // build get user by id REST API
    @GetMapping("{id}") // Annotation for mapping HTTP GET requests onto specific handler methods
    public ResponseEntity<User> getUserById(@PathVariable  long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id:" + id));
        return ResponseEntity.ok(user);
    }

    // build update user REST API
    @PutMapping("{id}") // Annotation for mapping HTTP PUT requests onto specific handler methods
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User userDetails) { //@PathVariable annotation to extract the templated part of the URI (id), @RequestBody maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + id));

        updateUser.setUsername(userDetails.getUsername());
        updateUser.setPassword(Hasher.hash(userDetails.getPassword()));
        updateUser.setRole(userDetails.getRole());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    // build delete user REST API
    @DeleteMapping("{id}") // Annotation for mapping HTTP DELETE requests onto specific handler methods.
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + id));

        userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }

}
