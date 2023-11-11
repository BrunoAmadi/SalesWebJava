package com.example.firstAPI.services;

import com.example.firstAPI.DTO.SellerDTO;
import com.example.firstAPI.models.Seller;
import com.example.firstAPI.repositories.SellerRepository;
import com.example.firstAPI.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SellerService {


    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository){

        this.sellerRepository = sellerRepository;
    }


    public List<Seller> findAll(){

        return sellerRepository.findAll();
    }


    public Seller findById(long id) throws ResourceNotFoundException{

        Optional<Seller> optinalSeller = sellerRepository.findById(id);

        if(optinalSeller.isPresent()){
            return optinalSeller.get();
        }else{
            throw  new ResourceNotFoundException("Id não encontrado " + id);

        }

    }


    public Seller insertSeller (SellerDTO sellerDTO){

        //convertendo SellerDTO que chegou como parametro para Seller e inserir no BD

         Seller seller = new Seller();
         seller.setName(sellerDTO.getName());
         seller.setEmail(sellerDTO.getEmail());
         seller.setBirthDate(sellerDTO.getBirthDate());
         seller.setBaseSalary(sellerDTO.getBaseSalary());
         seller.setDepartment(sellerDTO.getDepartment());


        if(!sellerRepository.findById(seller.getId()).isPresent()){
           return sellerRepository.save(seller);

        }else{
            throw new ResourceNotFoundException("Usuario já existe");
        }

    }

    

}
