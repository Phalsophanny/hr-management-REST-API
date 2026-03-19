package com.example.hr_management.mapper;

import com.example.hr_management.dto.department.DepartmentRequestDTO;
import com.example.hr_management.dto.department.DepartmentResponseDTO;
import com.example.hr_management.entity.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentRequestDTO dto){

        Department dep = new Department();

        dep.setDepartmentName(dto.getDepartmentName());

        return dep;
    }

    public static DepartmentResponseDTO toDTO(Department d){
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setDepartmentId(d.getDepartmentId());
        dto.setDepartmentName(d.getDepartmentName());
        dto.setCreatedDate(d.getCreatedDate());
        dto.setUpdatedDate(d.getUpdatedDate());
        return dto;
    }

}
