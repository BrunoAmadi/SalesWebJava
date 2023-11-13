package com.example.firstAPI.models;

import com.example.firstAPI.models.Enums.SaleStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="SalesRecords")
public class SalesRecord implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saleDate",columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private SaleStatus status;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;


    public SalesRecord(){

    }

    public SalesRecord(Long id, LocalDateTime date, Double amount, SaleStatus status, Seller seller) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
