package com.example.hr_management.service.employee;

import com.example.hr_management.dto.employee.EmployeeRequestDTO;
import com.example.hr_management.dto.employee.EmployeeResponseDTO;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO e);
    Page<EmployeeResponseDTO> getEmployees(int page,int size);
    EmployeeResponseDTO getEmployeeById(Long id);
//    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);
}
