package com.example.hr_management.service.employee;

import com.example.hr_management.dto.employee.EmployeeRequestDTO;
import com.example.hr_management.dto.employee.EmployeeResponseDTO;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO e);
}
