package com.example.hr_management.mapper;

import com.example.hr_management.dto.employee.EmployeeRequestDTO;
import com.example.hr_management.dto.employee.EmployeeResponseDTO;
import com.example.hr_management.entity.Employee;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeRequestDTO dto){
        Employee e = new Employee();
        e.setFirstName(dto.getFirstName());
        e.setLastName(dto.getLastName());
        e.setGender(dto.getGender());
        e.setDob(dto.getDob());
        e.setPhone(dto.getPhone());
        e.setEmail(dto.getEmail());

        return e;
    }

    public static EmployeeResponseDTO toDTO(Employee e){
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setEmployeeId(e.getEmployeeId());
        dto.setFirstName(e.getFirstName());
        dto.setLastName(e.getLastName());
        dto.setGender(e.getGender());
        dto.setDob(e.getDob());
        dto.setPhone(e.getPhone());
        dto.setEmail(e.getEmail());
        dto.setDepartmentName(e.getDepartment().getDepartmentName());
        dto.setPositionName(e.getPosition().getPositionName());
        dto.setCreatedDate(e.getCreatedDate());
        dto.setUpdatedDate(e.getUpdatedDate());
        return dto;
    }
}
