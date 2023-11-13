package com.example.firstAPI.controller;

import com.example.firstAPI.DTO.SalesRecordDTO;
import com.example.firstAPI.services.SalesRecordService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SalesRecordController {

    private final SalesRecordService salesRecordService;

    public SalesRecordController(SalesRecordService salesRecordService) {
        this.salesRecordService = salesRecordService;
    }

    @GetMapping
    public List<SalesRecordDTO> findAll() {
        return salesRecordService.findAll();
    }

    @GetMapping(value = "/simpleSearch")
    public List<SalesRecordDTO> simpleSearch(@RequestParam("init") String init, @RequestParam("end") String end) {

        LocalDateTime dateInit = LocalDateTime.parse(init);
        LocalDateTime dateEnd = LocalDateTime.parse(end);

        return salesRecordService.simpleSearch(dateInit, dateEnd);





    }


}
