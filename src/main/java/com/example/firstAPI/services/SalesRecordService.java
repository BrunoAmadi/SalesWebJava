package com.example.firstAPI.services;

import com.example.firstAPI.repositories.SalesRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesRecordService {

    private final SalesRecordRepository salesRecordRepository;

    public SalesRecordService(SalesRecordRepository salesRecordRepository){
     this.salesRecordRepository = salesRecordRepository;
 }






}
