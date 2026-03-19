package com.example.hr_management.repository;

import com.example.hr_management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    List<Department> findByIsDeletedFalse();
}
