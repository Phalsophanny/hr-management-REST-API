package com.example.hr_management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "departments" ,schema = "hr")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;
    private String departmentName;
    private Timestamp createdDate;
}
