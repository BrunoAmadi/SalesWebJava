package com.example.firstAPI.controller;
import com.example.firstAPI.dto.DepartmentDTO;
import com.example.firstAPI.services.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
@CrossOrigin
public class DepartmentController {


    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @Operation(summary = "Listar", description = "Retorna uma lista de todos os departamentos", tags = "Departments")
    @GetMapping
    public List<DepartmentDTO> findAll(){
        return departmentService.findAll();
    }




}
