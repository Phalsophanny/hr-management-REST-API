package com.example.hr_management.service.employee;

import com.example.hr_management.dto.employee.EmployeeRequestDTO;
import com.example.hr_management.dto.employee.EmployeeResponseDTO;
import com.example.hr_management.entity.Department;
import com.example.hr_management.entity.Employee;
import com.example.hr_management.entity.Position;
import com.example.hr_management.exception.BadRequestException;
import com.example.hr_management.exception.ResourceNotFoundException;
import com.example.hr_management.mapper.EmployeeMapper;
import com.example.hr_management.repository.DepartmentRepository;
import com.example.hr_management.repository.EmployeeRepository;
import com.example.hr_management.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository emp_repo;
    @Autowired
    private DepartmentRepository dep_repo;
    @Autowired
    private PositionRepository pos_repo;

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto){
        if (dto.getDepartmentId() == null) {
            throw new BadRequestException("Department ID is required");
        }
        if (dto.getPositionId() == null){
            throw new BadRequestException("Position ID is required");
        }
        System.out.println("DeptId: " + dto.getDepartmentId());
        System.out.println("PosId: " + dto.getPositionId());
        Employee employee = EmployeeMapper.toEntity(dto);

        Department department = dep_repo.findById(dto.getDepartmentId())
                .orElseThrow(()-> new ResourceNotFoundException("Department Not Found!"));

        Position position = pos_repo.findById(dto.getPositionId())
                .orElseThrow(()-> new ResourceNotFoundException("Position Not found"));


        employee.setDepartment(department);
        employee.setPosition(position);
        emp_repo.save(employee);
        return EmployeeMapper.toDTO(employee);
    }
}
