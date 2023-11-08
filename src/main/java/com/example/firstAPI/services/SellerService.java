package com.example.firstAPI.services;

import com.example.firstAPI.models.Seller;
import com.example.firstAPI.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;


    public List<Seller> findAll(){
        return sellerRepository.findAll();
    }




}
