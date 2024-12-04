package com.cs393Project.cs393Project.services;

import com.cs393Project.cs393Project.models.Location;
import com.cs393Project.cs393Project.Repositories.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationService locationService;

    private Location location;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        location = new Location("Sabiha Gokcen");
    }

    @Test
    public void testGetAllLocations() {
        when(locationRepository.findAll()).thenReturn(List.of(location));

        List<Location> locations = locationService.getAllLocations();
        assertEquals(1, locations.size());
        assertEquals("Sabiha Gokcen", locations.get(0).getLocationName());
    }

    @Test
    public void testGetLocationById() {
        when(locationRepository.findById(1L)).thenReturn(Optional.of(location));

        Optional<Location> result = locationService.getLocationById(1L);
        assertTrue(result.isPresent());
        assertEquals("Sabiha Gokcen", result.get().getLocationName());
    }

    @Test
    public void testAddLocation() {
        when(locationRepository.save(location)).thenReturn(location);

        Location result = locationService.addLocation(location);
        assertNotNull(result);
        assertEquals("Sabiha Gokcen", result.getLocationName());
    }

    @Test
    public void testDeleteLocation() {
        doNothing().when(locationRepository).deleteById(1L);

        locationService.deleteLocation(1L);
        verify(locationRepository, times(1)).deleteById(1L);
    }
}
