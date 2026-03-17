package com.example.hr_management.repository;

import com.example.hr_management.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Long> {
}
