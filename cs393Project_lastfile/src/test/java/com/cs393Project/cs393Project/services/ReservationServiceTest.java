package com.cs393Project.cs393Project.services;

import com.cs393Project.cs393Project.models.Reservation;
import com.cs393Project.cs393Project.Repositories.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    private Reservation reservation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        reservation = new Reservation("R12345678", null, null, null, null, "CONFIRMED");
    }

    @Test
    public void testGetAllReservations() {
        when(reservationRepository.findAll()).thenReturn(List.of(reservation));

        List<Reservation> reservations = reservationService.getAllReservations();
        assertEquals(1, reservations.size());
        assertEquals("R12345678", reservations.get(0).getReservationNumber());
    }

    @Test
    public void testGetReservationById() {
        when(reservationRepository.findById(1L)).thenReturn(Optional.of(reservation));

        Optional<Reservation> result = reservationService.getReservationById(1L);
        assertTrue(result.isPresent());
        assertEquals("R12345678", result.get().getReservationNumber());
    }

    @Test
    public void testAddReservation() {
        when(reservationRepository.save(reservation)).thenReturn(reservation);

        Reservation result = reservationService.addReservation(reservation);
        assertNotNull(result);
        assertEquals("R12345678", result.getReservationNumber());
    }

    @Test
    public void testDeleteReservation() {
        doNothing().when(reservationRepository).deleteById(1L);

        reservationService.deleteReservation(1L);
        verify(reservationRepository, times(1)).deleteById(1L);
    }
}
