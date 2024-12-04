package com.cs393Project.cs393Project.services;

import com.cs393Project.cs393Project.models.Car;
import com.cs393Project.cs393Project.Repositories.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    private Car car;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        car = new Car("CAR123", "34XYZ123", 5, "Toyota", "Corolla", 20000, "Automatic", 50.0, "AVAILABLE", "Standard");
    }

    @Test
    public void testGetAllCars() {
        when(carRepository.findAll()).thenReturn(List.of(car));

        List<Car> cars = carService.getAllCars();
        assertEquals(1, cars.size());
        assertEquals("Toyota", cars.get(0).getBrand());
    }

    @Test
    public void testGetCarById() {
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        Optional<Car> result = carService.getCarById(1L);
        assertTrue(result.isPresent());
        assertEquals("Toyota", result.get().getBrand());
    }

    @Test
    public void testAddCar() {
        when(carRepository.save(car)).thenReturn(car);

        Car result = carService.addCar(car);
        assertNotNull(result);
        assertEquals("Toyota", result.getBrand());
    }

    @Test
    public void testDeleteCar() {
        doNothing().when(carRepository).deleteById(1L);

        carService.deleteCar(1L);
        verify(carRepository, times(1)).deleteById(1L);
    }
}
