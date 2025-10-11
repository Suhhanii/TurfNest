package com.turfNest.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.turfNest.dao.LoginRequest;
import com.turfNest.dao.RegisterRequest;
import com.turfNest.entity.User;
import com.turfNest.security.JwtUtil;
import com.turfNest.user.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("email isalready in use");

        }
        if (!request.getContact().matches("^[6-9]\\d{9}$")) {
            return ResponseEntity.badRequest().body(" invalid contact number");
        }

        int account_type_value = 0;
        if ("USER".equalsIgnoreCase(request.getAccount_type())) {

            account_type_value = 1;
        } else if ("OWNER".equalsIgnoreCase(request.getAccount_type())) {
            account_type_value = 2;

        } else {
            return ResponseEntity.badRequest().body("Invalid account type");
        }

        User user = new User();
        user.setFirst_name(request.getFirst_name());
        user.setLast_name(request.getLast_name());
        user.setEmail(request.getEmail());
        user.setContact(request.getContact());
        user.setAddress(request.getAddress());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAccount_type(request.getAccount_type());
        userRepository.save(user);
        return ResponseEntity.ok("user registerd successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginUser) {
        Optional<User> userOptional = userRepository.findByEmail(loginUser.getEmail());
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(401).body("User not found");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        // 🔑 Generate JWT Token using email
        String token = jwtUtil.generateToken(user.getEmail());

        return ResponseEntity.ok(
                Map.of(
                        "token", token,
                        "email", user.getEmail(),
                        "account_type", user.getAccount_type()));
    }
}
