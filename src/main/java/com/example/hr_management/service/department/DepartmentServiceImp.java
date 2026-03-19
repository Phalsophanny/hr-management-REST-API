package com.example.hr_management.service.department;

import com.example.hr_management.dto.department.DepartmentRequestDTO;
import com.example.hr_management.dto.department.DepartmentResponseDTO;
import com.example.hr_management.entity.Department;
import com.example.hr_management.exception.BadRequestException;
import com.example.hr_management.exception.ResourceNotFoundException;
import com.example.hr_management.mapper.DepartmentMapper;
import com.example.hr_management.repository.DepartmentRepository;
import com.example.hr_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository dep_repo;
    @Autowired
    private EmployeeRepository emp_repo;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto){
        Department dep = DepartmentMapper.toEntity(dto);
        dep_repo.save(dep);
        return DepartmentMapper.toDTO(dep);
    }

    @Override
    public Page<DepartmentResponseDTO> getDepartments(int page,int size){
        return dep_repo.findAll(PageRequest.of(page,size)).map(DepartmentMapper::toDTO);
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long id){

        Department dep = dep_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department ID not found!"));
        return DepartmentMapper.toDTO(dep);
    }

    @Override
    public DepartmentResponseDTO updateDepartment(Long id,DepartmentRequestDTO dto){
        if(id == null){
            throw new BadRequestException("Department ID required.");
        }

        Department dep = dep_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department ID not found!"));

        dep.setDepartmentName(dto.getDepartmentName());
        dep.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

        Department update = dep_repo.save(dep);


        return DepartmentMapper.toDTO(update);
    }

    @Override
    public void deleteDepartment(Long id){

        if(id == null){
            throw new BadRequestException("Department ID required.");
        }

        Department dep = dep_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department ID not found!" + id));

        if(Boolean.TRUE.equals(dep.getIsDeleted())){
            throw new BadRequestException("Department ID already deleted.");
        }

        dep.setIsDeleted(true);
        dep.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        dep.setDeletedBy("ADMIN");

        dep_repo.save(dep);

//        dep_repo.delete(dep);

    }

}
