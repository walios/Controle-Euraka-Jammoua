package com.elkastali.clientservice.controller;


import com.elkastali.clientservice.entities.Client;
import com.elkastali.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.elkastali.clientservice.repository.ClientRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/client")
public class ClientController {

    //private final ClientRepository clientRepository;

    @Autowired
    public ClientService service;

    @GetMapping
    public List<Client> findAll(){
        return service.findAll();
    }

        @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) throws Exception {

        return service.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Client client){

        service.addClient(client);
    }
}
