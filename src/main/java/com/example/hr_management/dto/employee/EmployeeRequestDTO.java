package com.example.hr_management.dto.employee;

import lombok.Data;
import java.time.LocalDate;
@Data
public class EmployeeRequestDTO {
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dob;
    private String phone;
    private String email;
    private Long departmentId;
    private Long positionId;

}
