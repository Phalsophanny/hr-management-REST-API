package com.example.hr_management.dto.position;

import lombok.Data;

@Data
public class PositionRequestDTO {
    private long positionId;
    private String positionName;
    private Double baseSalary;
}
