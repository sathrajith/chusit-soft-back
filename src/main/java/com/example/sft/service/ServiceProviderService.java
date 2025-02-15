package com.example.sft.service;



import com.example.sft.entities.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {
    ServiceProvider registerServiceProvider(ServiceProvider serviceProvider);
    List<ServiceProvider> getAllServiceProviders();
    List<String> getAllServiceProviderEmails();

}
