package com.cs393Project.cs393Project.services;

import com.cs393Project.cs393Project.Repositories.ServiceRepository;
import com.cs393Project.cs393Project.models.Service;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public Service addService(Service service) {
        return serviceRepository.save(service);
    }

    public Service updateService(Service service) {
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
