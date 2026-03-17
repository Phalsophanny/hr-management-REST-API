package com.example.hr_management.controller;

import com.example.hr_management.dto.department.DepartmentRequestDTO;
import com.example.hr_management.dto.department.DepartmentResponseDTO;
import com.example.hr_management.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService dep_service;

    @PostMapping
    public DepartmentResponseDTO create(@RequestBody DepartmentRequestDTO dto){
        return dep_service.createDepartment(dto);
    }

}
