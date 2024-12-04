package com.cs393Project.cs393Project.services;

import com.cs393Project.cs393Project.models.Equipment;
import com.cs393Project.cs393Project.Repositories.EquipmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EquipmentServiceTest {

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private EquipmentService equipmentService;

    private Equipment equipment;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        equipment = new Equipment("GPS", 15.0);
    }

    @Test
    public void testGetAllEquipment() {
        when(equipmentRepository.findAll()).thenReturn(List.of(equipment));

        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        assertEquals(1, equipmentList.size());
        assertEquals("GPS", equipmentList.get(0).getName());
    }

    @Test
    public void testGetEquipmentById() {
        when(equipmentRepository.findById(1L)).thenReturn(Optional.of(equipment));

        Optional<Equipment> result = equipmentService.getEquipmentById(1L);
        assertTrue(result.isPresent());
        assertEquals("GPS", result.get().getName());
    }

    @Test
    public void testAddEquipment() {
        when(equipmentRepository.save(equipment)).thenReturn(equipment);

        Equipment result = equipmentService.addEquipment(equipment);
        assertNotNull(result);
        assertEquals("GPS", result.getName());
    }

    @Test
    public void testDeleteEquipment() {
        doNothing().when(equipmentRepository).deleteById(1L);

        equipmentService.deleteEquipment(1L);
        verify(equipmentRepository, times(1)).deleteById(1L);
    }
}
