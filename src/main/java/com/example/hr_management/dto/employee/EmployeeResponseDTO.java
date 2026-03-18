package com.example.hr_management.dto.employee;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
@Data
public class EmployeeResponseDTO  {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dob;
    private String phone;
    private String email;
    private String departmentName;
    private String positionName;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
