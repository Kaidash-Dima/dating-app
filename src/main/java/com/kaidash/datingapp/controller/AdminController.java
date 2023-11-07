package com.kaidash.datingapp.controller;

import com.kaidash.datingapp.entity.Interest;
import com.kaidash.datingapp.entity.User;
import com.kaidash.datingapp.service.InterestService;
import com.kaidash.datingapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final InterestService interestService;

    public AdminController(UserService userService, InterestService interestService) {
        this.userService = userService;
        this.interestService = interestService;
    }

    @GetMapping
    public ResponseEntity<List<Interest>> getAllInterests() {
        List<Interest> interests = interestService.getAllInterests();
        return ResponseEntity.ok(interests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interest> getInterestById(@PathVariable Long id) {
        Interest interest = interestService.getInterestById(id);
        if (interest != null) {
            return ResponseEntity.ok(interest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/subinterests")
    public ResponseEntity<List<Interest>> getSubinterestsByParentInterest(@PathVariable Long id) {
        Interest parentInterest = interestService.getInterestById(id);
        if (parentInterest != null) {
            List<Interest> subinterests = interestService.getSubinterestsByParentInterest(parentInterest);
            return ResponseEntity.ok(subinterests);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Interest> saveInterest(@RequestBody Interest interest) {
        Interest savedInterest = interestService.saveInterest(interest);
        return ResponseEntity.ok(savedInterest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterest(@PathVariable Long id) {
        interestService.deleteInterest(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public String adminData() {
        return "Admin data";
    }

    // READ (single user by ID)
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        Optional<User> users = Optional.ofNullable(userService.findById(id));
//        return users.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
    @GetMapping("/active-users")
    public List<User> getActiveUsers() {
        return userService.getActiveUsers();
    }
}
