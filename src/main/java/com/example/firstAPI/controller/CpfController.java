package com.example.firstAPI.controller;

import com.example.firstAPI.services.cpfservice.Adress;
import com.example.firstAPI.services.cpfservice.CpfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sellers/createseller")
public class CpfController {


    private final CpfService cpfService;

    public CpfController(CpfService cpfService) {
        this.cpfService = cpfService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Adress> searchAdress (@PathVariable("cep") String cep){
        Adress adress = cpfService.searchAdress(cep);

        if(adress == null ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(adress);

    }


}
