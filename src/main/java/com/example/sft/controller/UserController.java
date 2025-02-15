package com.example.sft.controller;


import com.example.sft.entities.User;
import com.example.sft.service.EmailService;
import com.example.sft.service.ServiceProviderService;
import com.example.sft.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final EmailService emailService;
    private final ServiceProviderService serviceProviderService;

    public UserController(
            UserService userService,
            EmailService emailService,
            ServiceProviderService serviceProviderService) {
        this.userService = userService;
        this.emailService = emailService;
        this.serviceProviderService = serviceProviderService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Register the user
        User registeredUser = userService.registerUser(user);

        // Send a thanking email to the newly registered user
        String subject = "Thank You for Registering!";
        String text = "Dear " + user.getEmail() + ",\n\n"
                + "Thank you for registering with us. We appreciate your trust and look forward to serving you.\n\n"
                + "Best regards,\n"
                + "chusit\n\n"
                + "By:\n     Teksas customer support";
        emailService.sendEmail(Collections.singletonList(user.getEmail()), subject, text);

        return ResponseEntity.ok(registeredUser);
    }
    // Other methods...

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

}




