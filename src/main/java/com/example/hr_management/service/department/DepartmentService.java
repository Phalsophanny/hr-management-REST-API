package com.example.hr_management.service.department;

import com.example.hr_management.dto.department.DepartmentRequestDTO;
import com.example.hr_management.dto.department.DepartmentResponseDTO;

public interface DepartmentService {
    DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto);
}
