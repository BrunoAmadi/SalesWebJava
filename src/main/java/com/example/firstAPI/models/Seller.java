package com.example.firstAPI.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name ="Sellers")
public class Seller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDate;

    private Double baseSalary;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany
    private List<SalesRecord> salesRecords = new ArrayList<>();


    public Seller(){

    }

    public Seller(Long id, String name, String email, LocalDate birthDate, Double baseSalary, Department department){
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
        this.department = department;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



    public void addSales(SalesRecord sr){
        salesRecords.add(sr);
    }

    public void removeSales(SalesRecord sr){
        salesRecords.remove(sr);
    }

    public double totalSales(LocalDate initial, LocalDate end){
        double sum = salesRecords.stream().filter(x -> !x.getDate().isBefore(initial.atStartOfDay()) && !x.getDate().isAfter(end.atStartOfDay()))
                .mapToDouble(SalesRecord::getAmount).sum();

        return sum;
    }



}
