package com.kaidash.datingapp.controller;

import com.kaidash.datingapp.entity.Users;
import com.kaidash.datingapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping("/")
    public Users createUser(@RequestBody Users users) {
        return userService.save(users);
    }

    // READ (single user by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Optional<Users> users = Optional.ofNullable(userService.findById(id));
        return users.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // READ (all users)
    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userService.findAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        Users users = userService.findById(id);
        if (users == null) {
            return ResponseEntity.notFound().build();
        }

        users.setUserName(updatedUser.getUserName());
        users.setEmail(updatedUser.getEmail());
        users.setPassword(updatedUser.getPassword());

        userService.save(users);
        return ResponseEntity.ok(users);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Users users = userService.findById(id);
        if (users == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
