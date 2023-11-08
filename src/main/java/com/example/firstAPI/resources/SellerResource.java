package com.example.firstAPI.resources;

import com.example.firstAPI.models.Seller;
import com.example.firstAPI.services.SellerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellerResource {

    private SellerService sellerService;

    @GetMapping
    public List findAll(){
        List<Seller> list = sellerService.findAll();
        return list;
    }



}
