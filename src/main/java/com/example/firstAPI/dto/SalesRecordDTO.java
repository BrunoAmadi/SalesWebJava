package com.example.firstAPI.dto;

import com.example.firstAPI.models.Enums.SaleStatus;
import com.example.firstAPI.models.SalesRecord;
import java.time.LocalDateTime;

public class SalesRecordDTO {


    private long id;
    private LocalDateTime saleDate;

    private String sellerName;

    private String departmentName;
    private Double amount;

    private SaleStatus saleStatus;

    public SalesRecordDTO(SalesRecord salesRecord){
        this.id = salesRecord.getId();
        this.saleDate = salesRecord.getDate();
        this.sellerName = salesRecord.getSeller().getName();
        this.departmentName = salesRecord.getSeller().getDepartment().getName();
        this.amount = salesRecord.getAmount();
        this.saleStatus = salesRecord.getStatus();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }
}
