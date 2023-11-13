package com.example.firstAPI.DTO;

import com.example.firstAPI.models.Seller;

public class DepartmentDTO {

    private String name;

    public DepartmentDTO(){

    }
    public DepartmentDTO(Seller entity){
        this.name = entity.getName();
    }

    public DepartmentDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
