package com.example.firstAPI.controller;

import com.example.firstAPI.dto.SellerDTO;
import com.example.firstAPI.services.SellerService;
import com.example.firstAPI.services.exceptions.DbIntegrityException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
@CrossOrigin
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }


    @Operation(summary = "Listar todos Sellers", description = "Retorna uma lista com todos os Sellers", tags = "Sellers")
    @GetMapping
    public List<SellerDTO> findAll() {
        return sellerService.findAll();

    }

    @Operation(summary = "Buscar um seller", description = "Retorna um Seller pelo id", tags = "Sellers")
    @GetMapping(value = "/{id}")
    public SellerDTO findById(@PathVariable long id) {
        return sellerService.findById(id);

    }


    @Operation(summary = "Inserir um seller", description = "inserir um seller passando na requisição um Seller", tags = "Sellers")
    @PostMapping(value = "/insert")
    public SellerDTO insertSeller(@RequestBody SellerDTO sellerDTO) {
        return sellerService.insert(sellerDTO);


    }

    @Operation(summary = "Atualizar", description = "Atualiza um seller passando o id", tags = "Sellers")
    @PutMapping(value = "/put/{id}")
    public SellerDTO putSeller(@RequestBody SellerDTO sellerDTO, @PathVariable long id) {
        return sellerService.putSeller(sellerDTO, id);

    }


    @Operation(summary = "Remover", description = "Remove um vendedor passando o id", tags = "Sellers")
    @DeleteMapping(value = "/delete/{id}")
    public void deleteSeller(@PathVariable long id) throws DbIntegrityException {

        sellerService.deleteSeller(id);

    }

}
