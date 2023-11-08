package com.example.firstAPI.services;

import com.example.firstAPI.repositories.SalesRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesRecordService {


    @Autowired
    private SalesRecordRepository salesRecordRepository;


}
