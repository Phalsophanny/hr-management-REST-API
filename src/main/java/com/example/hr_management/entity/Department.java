package com.example.hr_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Table(name = "departments" ,schema = "hr")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;
    private String departmentName;
    @CreatedDate
    @Column(updatable = false)
    private Timestamp createdDate;

    private Timestamp updatedDate;

    @Column(name="is_deleted")
    private Boolean isDeleted = false;

    private String deletedBy;
    private Timestamp deletedDate;
}
