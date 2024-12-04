package com.cs393Project.cs393Project.services;

import com.cs393Project.cs393Project.models.Service;
import com.cs393Project.cs393Project.Repositories.ServiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceServiceTest {

    @Mock
    private ServiceRepository serviceRepository;

    @InjectMocks
    private ServiceService serviceService;

    private Service service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new Service("Roadside Assistance", 20.0);
    }

    @Test
    public void testGetAllServices() {
        when(serviceRepository.findAll()).thenReturn(List.of(service));

        List<Service> services = serviceService.getAllServices();
        assertEquals(1, services.size());
        assertEquals("Roadside Assistance", services.get(0).getName());
    }

    @Test
    public void testGetServiceById() {
        when(serviceRepository.findById(1L)).thenReturn(Optional.of(service));

        Optional<Service> result = serviceService.getServiceById(1L);
        assertTrue(result.isPresent());
        assertEquals("Roadside Assistance", result.get().getName());
    }

    @Test
    public void testAddService() {
        when(serviceRepository.save(service)).thenReturn(service);

        Service result = serviceService.addService(service);
        assertNotNull(result);
        assertEquals("Roadside Assistance", result.getName());
    }

    @Test
    public void testDeleteService() {
        doNothing().when(serviceRepository).deleteById(1L);

        serviceService.deleteService(1L);
        verify(serviceRepository, times(1)).deleteById(1L);
    }
}
