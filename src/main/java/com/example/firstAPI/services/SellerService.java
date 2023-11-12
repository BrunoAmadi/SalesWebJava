package com.example.firstAPI.services;

import com.example.firstAPI.DTO.SellerDTO;
import com.example.firstAPI.models.Seller;
import com.example.firstAPI.repositories.SellerRepository;
import com.example.firstAPI.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SellerService {


    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {

        this.sellerRepository = sellerRepository;
    }


    public List<Seller> findAll() {

        return sellerRepository.findAll();
    }


    public Seller findById(long id) throws ResourceNotFoundException {

        Optional<Seller> optinalSeller = sellerRepository.findById(id);

        if (optinalSeller.isPresent()) {
            return optinalSeller.get();

        } else {
            throw new ResourceNotFoundException("Id não encontrado " + id);

        }

    }


    public Seller insert(SellerDTO sellerDTO) {

        //convertendo SellerDTO que chegou como parametro para Seller e inserir no BD

        Seller seller = new Seller();
        seller.setName(sellerDTO.getName());
        seller.setEmail(sellerDTO.getEmail());
        seller.setBirthDate(sellerDTO.getBirthDate());
        seller.setBaseSalary(sellerDTO.getBaseSalary());
        seller.setDepartment(sellerDTO.getDepartment());
        return sellerRepository.save(seller);

    }


    public SellerDTO putSeller(SellerDTO sellerDTO, long id)  throws ResourceNotFoundException {


        if (sellerRepository.findById(id).isPresent()) {
           Seller seller = sellerRepository.findById(id).get();
            seller.setName(sellerDTO.getName());
            seller.setEmail(sellerDTO.getEmail());
            seller.setBirthDate(sellerDTO.getBirthDate());
            seller.setBaseSalary(sellerDTO.getBaseSalary());
            seller.setDepartment(sellerDTO.getDepartment());
            return transferDTO(sellerRepository.save(seller));

        } else {
            throw new ResourceNotFoundException("Usuario não encontrado");
        }


    }

    // função para transformar seller em SellerDTO e enviar para o controller
    public SellerDTO transferDTO(Seller obj) {
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setName(obj.getName());
        sellerDTO.setEmail(obj.getEmail());
        sellerDTO.setBirthDate(obj.getBirthDate());
        sellerDTO.setBaseSalary(obj.getBaseSalary());
        sellerDTO.setDepartment(obj.getDepartment());
        return sellerDTO;


    }
}


