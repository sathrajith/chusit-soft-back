package com.example.sft.service;



import com.example.sft.entities.ContactForm;

import java.util.List;

public interface ContactFormService {
    ContactForm submitContactForm(ContactForm contactForm);
    List<ContactForm> getAllContactForms();
}