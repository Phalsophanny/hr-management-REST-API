package com.example.hr_management.dto.department;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class DepartmentResponseDTO {
    private long departmentId;
    private String departmentName;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
