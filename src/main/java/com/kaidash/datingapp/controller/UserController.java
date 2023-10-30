package com.kaidash.datingapp.controller;

import com.kaidash.datingapp.entity.User;
import com.kaidash.datingapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userData(Principal principal){
        return principal.getName();
    }


    // CREATE
//    @PostMapping("/")
//    public User createUser(@RequestBody User user) {
//        return userService.save(user);
//    }

//    @GetMapping("/admin")
//    public String adminData() {
//        return "Admin data";
//    }
//    // READ (single user by ID)
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        Optional<User> users = Optional.ofNullable(userService.findById(id));
//        return users.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
    // READ (all users)
//    @GetMapping("/")
//    public List<User> getAllUsers() {
//        return userService.findAll();
//    }
//
//    // UPDATE
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//        User user = userService.findById(id);
//        if (user == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        user.setUsername(updatedUser.getUsername());
//        user.setEmail(updatedUser.getEmail());
//        user.setPassword(updatedUser.getPassword());
//
//        userService.save(user);
//        return ResponseEntity.ok(user);
//    }
//
//    // DELETE
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        User user = userService.findById(id);
//        if (user == null) {
//            return ResponseEntity.notFound().build();
//        }
//        userService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
