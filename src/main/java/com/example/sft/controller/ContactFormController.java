package com.example.sft.controller;


import com.example.sft.entities.ContactForm;
import com.example.sft.service.ContactFormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
//@CrossOrigin(origins = "*") // Allow frontend requests
public class ContactFormController {

    private final ContactFormService contactFormService;

    public ContactFormController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }

    @PostMapping
    public ResponseEntity<ContactForm> submitContactForm(@RequestBody ContactForm contactForm) {
        ContactForm savedContact = contactFormService.submitContactForm(contactForm);
        return ResponseEntity.ok(savedContact);
    }

    @GetMapping
    public ResponseEntity<List<ContactForm>> getAllContactForms() {
        return ResponseEntity.ok(contactFormService.getAllContactForms());
    }
}