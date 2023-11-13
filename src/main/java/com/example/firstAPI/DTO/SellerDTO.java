package com.example.firstAPI.DTO;

import com.example.firstAPI.models.Department;
import com.example.firstAPI.models.Seller;

import java.time.LocalDate;

public class SellerDTO {

    private String name;
    private String email;

    private LocalDate birthDate;

    private Double baseSalary;
    private Department department;

    public SellerDTO(){}

    public SellerDTO(Seller entity) {

        this.name = entity.getName();
        this.email = entity.getEmail();
        this.birthDate = entity.getBirthDate();
        this.baseSalary = entity.getBaseSalary();
        this.department = entity.getDepartment();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
