package com.cs393Project.cs393Project.Repositories;



import com.cs393Project.cs393Project.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

