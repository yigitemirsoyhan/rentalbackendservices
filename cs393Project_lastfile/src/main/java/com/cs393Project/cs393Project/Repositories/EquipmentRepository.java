package com.cs393Project.cs393Project.Repositories;


import com.cs393Project.cs393Project.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
