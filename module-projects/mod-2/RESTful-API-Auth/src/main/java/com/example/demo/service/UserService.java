package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Criminal;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        String username = (user.getUsername());
        String hashedPassword = Hasher.hash(user.getPassword());
        UserRole role = (user.getRole());

        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setRole(role);

        return this.userRepository.save(user);
    }

    public User updateUser(long id, User userDetails) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Criminal does not exist with id: " + id));

        updateUser.setUsername(userDetails.getUsername());
        updateUser.setPassword(Hasher.hash(userDetails.getPassword()));;
        updateUser.setRole(userDetails.getRole());

        return userRepository.save(updateUser);
    }
}
