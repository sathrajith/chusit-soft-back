package com.example.sft.impl;


import com.example.sft.entities.ContactForm;
import com.example.sft.repository.ContactFormRepository;
import com.example.sft.service.ContactFormService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactFormServiceImpl implements ContactFormService {

    private final ContactFormRepository contactFormRepository;

    public ContactFormServiceImpl(ContactFormRepository contactFormRepository) {
        this.contactFormRepository = contactFormRepository;
    }

    @Override
    public ContactForm submitContactForm(ContactForm contactForm) {
        return contactFormRepository.save(contactForm);
    }

    @Override
    public List<ContactForm> getAllContactForms() {
        return contactFormRepository.findAll();
    }
}