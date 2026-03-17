package com.example.hr_management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "positions",schema = "hr")
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long positionId;
    private String positionName;
    private Double baseSalary;
}
