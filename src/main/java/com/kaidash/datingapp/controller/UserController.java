package com.kaidash.datingapp.controller;

import com.kaidash.datingapp.entity.User;
import com.kaidash.datingapp.service.InterestService;
import com.kaidash.datingapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // READ (single user by ID)
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> users = Optional.ofNullable(userService.findById(id));
        return users.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        userService.save(user);
        return ResponseEntity.ok(user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setAccountDeleted(true);
        userService.save(user);
//        return ResponseEntity.noContent().build();
        return ResponseEntity.ok("User deleted");
    }

    @PostMapping("/addInterest")
    public ResponseEntity<Void> addInterestToUser(@RequestParam Long userId, @RequestParam Long interestId) {
        userService.addInterestToUser(userId, interestId);
        return ResponseEntity.noContent().build();
    }

}
