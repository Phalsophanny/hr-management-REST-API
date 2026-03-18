package com.example.hr_management.service.department;

import com.example.hr_management.dto.department.DepartmentRequestDTO;
import com.example.hr_management.dto.department.DepartmentResponseDTO;
import org.springframework.data.domain.Page;

public interface DepartmentService {
    DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto);
    Page<DepartmentResponseDTO> getDepartments(int page,int size);
    DepartmentResponseDTO getDepartmentById(Long id);
//    DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO dto);
}
