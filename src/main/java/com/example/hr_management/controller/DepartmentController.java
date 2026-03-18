package com.example.hr_management.controller;

import com.example.hr_management.dto.department.DepartmentRequestDTO;
import com.example.hr_management.dto.department.DepartmentResponseDTO;
import com.example.hr_management.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService dep_service;

    @PostMapping
    public DepartmentResponseDTO create(@RequestBody DepartmentRequestDTO dto){
        return dep_service.createDepartment(dto);
    }

    @GetMapping
    public Page<DepartmentResponseDTO> getDepartment(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        return dep_service.getDepartments(page,size);
    }

    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartmentById(@PathVariable Long id){
        return dep_service.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody DepartmentRequestDTO dto){
        return ResponseEntity.ok(dep_service.updateDepartment(id,dto));
    }

}
