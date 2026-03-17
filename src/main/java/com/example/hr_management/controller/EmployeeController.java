package com.example.hr_management.controller;

import com.example.hr_management.dto.employee.EmployeeRequestDTO;
import com.example.hr_management.dto.employee.EmployeeResponseDTO;
import com.example.hr_management.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService emp_service;

    @PostMapping
    public EmployeeResponseDTO create(@RequestBody EmployeeRequestDTO dto){
        return emp_service.createEmployee(dto);
    }

}
