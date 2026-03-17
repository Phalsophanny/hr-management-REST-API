package com.example.hr_management.service.department;

import com.example.hr_management.dto.department.DepartmentRequestDTO;
import com.example.hr_management.dto.department.DepartmentResponseDTO;
import com.example.hr_management.entity.Department;
import com.example.hr_management.mapper.DepartmentMapper;
import com.example.hr_management.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository dep_repo;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto){
        Department dep = DepartmentMapper.toEntity(dto);
        dep_repo.save(dep);
        return DepartmentMapper.toDTO(dep);
    }

}
