package com.example.firstAPI.controller;

import com.example.firstAPI.DTO.SellerDTO;
import com.example.firstAPI.services.SellerService;
import com.example.firstAPI.services.exceptions.DbIntegrityException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public List<SellerDTO> findAll() {
        return sellerService.findAll();

    }

    @GetMapping(value = "/{id}")
    public SellerDTO findById(@PathVariable long id) {
        return sellerService.findById(id);

    }


    @PostMapping(value = "/insert")
    public SellerDTO insertSeller(@RequestBody SellerDTO sellerDTO) {
        return sellerService.insert(sellerDTO);


    }

    @PutMapping(value = "/put/{id}")
    public SellerDTO putSeller(@RequestBody SellerDTO sellerDTO, @PathVariable long id) {
        return sellerService.putSeller(sellerDTO, id);

    }


    @DeleteMapping(value = "/delete/{id}")
    public void deleteSeller(@PathVariable long id) throws DbIntegrityException {

        sellerService.deleteSeller(id);

    }

}
