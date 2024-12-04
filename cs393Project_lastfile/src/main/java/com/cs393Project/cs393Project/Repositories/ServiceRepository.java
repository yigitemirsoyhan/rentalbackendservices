package com.cs393Project.cs393Project.Repositories;


import com.cs393Project.cs393Project.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}

