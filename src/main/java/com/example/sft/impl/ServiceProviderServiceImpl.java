package com.example.sft.impl;



import com.example.sft.entities.ServiceProvider;
import com.example.sft.repository.ServiceProviderRepository;
import com.example.sft.service.ServiceProviderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    private final ServiceProviderRepository serviceProviderRepository;

    public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }

    @Override
    public ServiceProvider registerServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findAll();
    }
}
