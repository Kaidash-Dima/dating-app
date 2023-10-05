package com.kaidash.datingapp.service;

import com.kaidash.datingapp.entity.Users;
import com.kaidash.datingapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
