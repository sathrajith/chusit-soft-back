package com.example.sft.controller;


import com.example.sft.entities.ContactForm;
import com.example.sft.service.ContactFormService;
import com.example.sft.service.EmailService;
import com.example.sft.service.ServiceProviderService;
import com.example.sft.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactFormController {

    private final ContactFormService contactFormService;
    private final EmailService emailService;
    private final UserService userService;
    private final ServiceProviderService serviceProviderService;

    public ContactFormController(
            ContactFormService contactFormService,
            EmailService emailService,
            UserService userService,
            ServiceProviderService serviceProviderService) {
        this.contactFormService = contactFormService;
        this.emailService = emailService;
        this.userService = userService;
        this.serviceProviderService = serviceProviderService;
    }

    @PostMapping
    public ResponseEntity<ContactForm> submitContactForm(@RequestBody ContactForm contactForm) {
        // Save the contact form
        ContactForm savedContact = contactFormService.submitContactForm(contactForm);

        // Send a thanking email to the user who submitted the contact form
        String subject = "Thank You for Contacting Us!";
        String text = "Dear " + contactForm.getName() + ",\n\n"
                + "Thank you for reaching out to us. We have received your message and will get back to you shortly.\n\n"
                + "Best regards,\n"
                + "Chusit \n\n"
                + "By: \n   Teksas Customer support";
        emailService.sendEmail(Collections.singletonList(contactForm.getEmail()), subject, text);

        return ResponseEntity.ok(savedContact);
    }

    @GetMapping
    public ResponseEntity<List<ContactForm>> getAllContactForms() {
        return ResponseEntity.ok(contactFormService.getAllContactForms());
    }
}

