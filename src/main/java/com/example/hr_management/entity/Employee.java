package com.example.hr_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dob;
    private String phone;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;


    @CreatedDate
    @Column(name = "created_date", updatable = false, nullable = false)
    private Timestamp createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Timestamp updatedDate;


}
