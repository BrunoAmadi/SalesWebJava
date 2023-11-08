package com.example.firstAPI.models;

import com.example.firstAPI.models.Enums.SaleStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="SalesRecords")
public class SalesRecord implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime date;

    private Double amount;

    private SaleStatus status;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;


    public SalesRecord(){

    }

    public SalesRecord(UUID id, LocalDateTime date, Double amount, SaleStatus status, Seller seller) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.seller = seller;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }





}
