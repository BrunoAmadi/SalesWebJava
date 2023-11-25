package com.example.firstAPI.services.cpfservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface CpfService {

    @GetMapping(value = "{cep}/json")
    Adress searchAdress(@PathVariable("cep") String cep);
}
