package com.example.hr_management.controller;

import com.example.hr_management.dto.employee.EmployeeRequestDTO;
import com.example.hr_management.dto.employee.EmployeeResponseDTO;
import com.example.hr_management.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService emp_service;

    @PostMapping
    public EmployeeResponseDTO create(@RequestBody EmployeeRequestDTO dto){
        return emp_service.createEmployee(dto);
    }

    @GetMapping
    public Page<EmployeeResponseDTO> getEmployees(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        return emp_service.getEmployees(page,size);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id){
        return emp_service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id,@RequestBody EmployeeRequestDTO dto){
        return emp_service.updateEmployee(id,dto);
    }


}
