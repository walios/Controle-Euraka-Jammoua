package com.elkastali.clientservice.service;

import com.elkastali.clientservice.entities.Client;
import com.elkastali.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){

        return clientRepository.findAll();
    }

    public Client findById(Long id) throws Exception{

        return clientRepository.findById(id).orElseThrow(()->new Exception("Invalid client ID"));
    }

    public void addClient(Client client){
        clientRepository.save(client);
    }

}
