package com.example.hr_management.dto.position;

import lombok.Data;

@Data
public class PositionResponseDTO {
    private long positionId;
    private String positionName;
    private double baseSalary;
}
