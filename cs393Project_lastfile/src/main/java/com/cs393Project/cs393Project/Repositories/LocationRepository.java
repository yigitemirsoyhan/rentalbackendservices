package com.cs393Project.cs393Project.Repositories;


import com.cs393Project.cs393Project.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

