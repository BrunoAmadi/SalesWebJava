package com.example.firstAPI.repositories;

import com.example.firstAPI.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {

}
