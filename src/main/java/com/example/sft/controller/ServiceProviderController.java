package com.example.sft.controller;


import com.example.sft.entities.ServiceProvider;
import com.example.sft.service.EmailService;
import com.example.sft.service.ServiceProviderService;
import com.example.sft.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/service-providers")
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;
    private final EmailService emailService;
    private final UserService userService;

    public ServiceProviderController(
            ServiceProviderService serviceProviderService,
            EmailService emailService,
            UserService userService) {
        this.serviceProviderService = serviceProviderService;
        this.emailService = emailService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ServiceProvider> registerServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        // Register the service provider
        ServiceProvider registeredProvider = serviceProviderService.registerServiceProvider(serviceProvider);

        // Send a thanking email to the newly registered service provider
        String subject = "Thank You for Registering as a Service Provider!";
        String text = "Dear " + serviceProvider.getEmail() + ",\n\n"
                + "Thank you for showing interest as a service provider.Our Customer support will reach you to discuss details. We appreciate your trust and look forward to working with you.\n\n"
                + "Best regards,\n"
                + "Chusit. \n \n"
                + "By: \n   Teksas Customer support";
        emailService.sendEmail(Collections.singletonList(serviceProvider.getEmail()), subject, text);

        return ResponseEntity.ok(registeredProvider);
    }

    // Other methods...

    @GetMapping
    public ResponseEntity<List<ServiceProvider>> getAllServiceProviders() {
        return ResponseEntity.ok(serviceProviderService.getAllServiceProviders());
    }

}





