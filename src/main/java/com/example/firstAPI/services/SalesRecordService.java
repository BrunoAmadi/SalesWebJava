package com.example.firstAPI.services;

import com.example.firstAPI.dto.SalesRecordDTO;
import com.example.firstAPI.repositories.SalesRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalesRecordService {

    private final SalesRecordRepository salesRecordRepository;

    public SalesRecordService(SalesRecordRepository salesRecordRepository){
     this.salesRecordRepository = salesRecordRepository;
 }

 public List<SalesRecordDTO> findAll(){
        return salesRecordRepository.findAll().stream().map(x -> new SalesRecordDTO(x)).toList();
 }

    public List<SalesRecordDTO> simpleSearch(LocalDateTime init, LocalDateTime end){

          return salesRecordRepository.findAll().stream()
                .filter(x -> !x.getDate().isBefore(init) && !x.getDate().isAfter(end))
                .map(SalesRecordDTO::new).toList();


    }




}
