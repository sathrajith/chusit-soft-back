package com.example.sft.controller;


import com.example.sft.entities.ServiceProvider;
import com.example.sft.service.ServiceProviderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-providers")
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @PostMapping("/register")
    public ResponseEntity<ServiceProvider> registerServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        return ResponseEntity.ok(serviceProviderService.registerServiceProvider(serviceProvider));
    }

    @GetMapping
    public ResponseEntity<List<ServiceProvider>> getAllServiceProviders() {
        return ResponseEntity.ok(serviceProviderService.getAllServiceProviders());
    }
}
