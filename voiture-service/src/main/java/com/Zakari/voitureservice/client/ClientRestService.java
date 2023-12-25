package com.elkastali.voitureservice.client;


import com.elkastali.voitureservice.entities.Client;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLIENT-SERVICE")

public interface ClientRestService {

    @GetMapping("/clients/{id}")
    Client findById(@PathVariable Long id);

    @GetMapping("/clients")
    List<Client> findAll();
}
