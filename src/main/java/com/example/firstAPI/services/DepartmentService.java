package com.example.firstAPI.services;

import com.example.firstAPI.dto.DepartmentDTO;
import com.example.firstAPI.models.Department;
import com.example.firstAPI.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

public DepartmentService(DepartmentRepository departmentRepository){
    this.departmentRepository = departmentRepository;

}

    public List<DepartmentDTO> findAll(){
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOS = departments.stream().map(x -> new DepartmentDTO(x.getName())).toList();
     return departmentDTOS;
    }




}
