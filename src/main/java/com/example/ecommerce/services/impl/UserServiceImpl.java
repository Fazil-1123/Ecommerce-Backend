package com.example.ecommerce.services.impl;

import com.example.ecommerce.domain.entities.User;
import com.example.ecommerce.repositories.UserRepository;
import com.example.ecommerce.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }

    @Override
    public User createUser(User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("User already has an ID!");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User must have an ID!");
        }
        if (!id.equals(user.getId())) {
            throw new IllegalArgumentException("User ID cannot be changed!");
        }

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));

        existingUser.setEmail(user.getEmail());
        if (user.getCart() != null) {
            existingUser.setCart(user.getCart());
        }

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
