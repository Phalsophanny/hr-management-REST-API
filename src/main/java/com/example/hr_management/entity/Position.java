package com.example.hr_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Table(name = "positions",schema = "hr")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long positionId;
    private String positionName;
    private Double baseSalary;
    @CreatedDate
    @Column(name = "created_date", updatable = false, nullable = false)
    private Timestamp createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Timestamp updatedDate;
}
