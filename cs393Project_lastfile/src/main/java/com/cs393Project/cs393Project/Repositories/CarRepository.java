package com.cs393Project.cs393Project.Repositories;
import com.cs393Project.cs393Project.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
