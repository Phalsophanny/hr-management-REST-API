package com.example.hr_management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dob;
    private String phone;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;


//    public Employee(){
//
//    }
//    public long getId(){
//        return employeeId;
//    }
//
//    public void setId(long employeeId){
//        this.employeeId = employeeId;
//    }
//
//    public String getFirstName(){
//        return firstName;
//    }
//
//    public void setFirstName(String firstName){
//        this.firstName = firstName;
//    }
//
//    public String getLastName(){
//        return lastName;
//    }
//
//    public void setLastName(String lastName){
//        this.lastName = lastName;
//    }
//
//    public String getGender(){
//        return gender;
//    }
//
//    public void setGender(String gender){
//        this.gender = gender;
//    }
//
//    public LocalDate getDob(){
//        return dob;
//    }
//
//    public void setDoB(LocalDate dob){
//        this.dob = dob;
//    }
//
//    public String getPhone(){
//        return phone;
//    }
//
//    public void setPhone(String phone){
//        this.phone = phone;
//    }
//
//    public String getEmail(){
//        return email;
//    }
//
//    public void setEmail(String email){
//        this.email = email;
//    }
//
//
//    public long getDepartmentId(){
//        return departmentId;
//    }
//    public void setDepartmentId(long departmentId){
//        this.departmentId = departmentId;
//    }
//
//    public long getPosition(){
//        return positionId;
//    }
//
//    public void setPositionId(long positionId){
//        this.positionId = positionId;
//    }
//

}
