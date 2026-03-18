package com.example.hr_management.dto.position;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PositionResponseDTO {
    private long positionId;
    private String positionName;
    private Double baseSalary;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
