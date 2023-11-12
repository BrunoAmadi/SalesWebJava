package com.example.firstAPI.services;

import com.example.firstAPI.DTO.DepartmentDTO;
import com.example.firstAPI.models.Department;
import com.example.firstAPI.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

public DepartmentService(DepartmentRepository departmentRepository){
    this.departmentRepository = departmentRepository;

}

    public List<DepartmentDTO> findAll(){
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOS = departments.stream().map(this::transformDepartmentDTO).toList();
     return departmentDTOS;
    }



    public DepartmentDTO transformDepartmentDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(department.getName());
        return departmentDTO;
    }
}
