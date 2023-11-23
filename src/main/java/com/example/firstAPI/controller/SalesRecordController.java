package com.example.firstAPI.controller;

import com.example.firstAPI.dto.SalesRecordDTO;
import com.example.firstAPI.services.SalesRecordService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
@CrossOrigin
public class SalesRecordController {

    private final SalesRecordService salesRecordService;

    public SalesRecordController(SalesRecordService salesRecordService) {
        this.salesRecordService = salesRecordService;
    }

    @Operation(summary = "Listar", description = "Retorna uma lista de todas as vendas (SalesRecords)", tags = "SalesRecord")
    @GetMapping
    public List<SalesRecordDTO> findAll() {
        return salesRecordService.findAll();
    }


    @Operation(summary = "Listagem filtadra", description = "Retorna uma lista filtrada de vendas de acordo com a data passada", tags = "SalesRecord")
    @GetMapping(value = "/simpleSearch")
    public List<SalesRecordDTO> simpleSearch(@RequestParam("init") String init, @RequestParam("end") String end) {

        LocalDateTime dateInit = LocalDateTime.parse(init);
        LocalDateTime dateEnd = LocalDateTime.parse(end);

        return salesRecordService.simpleSearch(dateInit, dateEnd);





    }


}
