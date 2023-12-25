package com.elkastali.voitureservice.service;

import com.elkastali.voitureservice.entities.CarResponse;
import com.elkastali.voitureservice.entities.Client;
import com.elkastali.voitureservice.entities.Voiture;
import com.elkastali.voitureservice.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class carService {

    @Autowired
    public VoitureRepository voitureRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String URL="http://localhost:8888/CLIENT-SERVICE";


    public List<CarResponse> findAll(){
        List<Voiture> cars=voitureRepository.findAll();
        ResponseEntity<Client[]> response = restTemplate.getForEntity(this.URL+"/api/client",Client[].class);
        Client[] clients = response.getBody();

        return cars.stream().map((Voiture voiture)->
                mapToCarResponse(voiture,clients)
                ).toList();
    }

    private CarResponse mapToCarResponse(Voiture car,Client[] clients){
        Client foundClient= Arrays.stream(clients)
                .filter(client->client.getId().equals(car.getClientId()))
                .findFirst()
                .orElse(null);

        return CarResponse.builder().id(car.getId())
                .brand(car.getMarque())
                .client(foundClient)
                .matricule(car.getMatricule())
                .model(car.getModele())
                .build();
    }

    public CarResponse findById(Long id) throws Exception {
        Voiture car = voitureRepository.findById(id).orElseThrow(() -> new Exception("Invalid car id"));
        Client client = restTemplate.getForObject(this.URL + "/api/client" + car.getClientId(), Client.class);
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getMarque())
                .client(client)
                .matricule(car.getMatricule())
                .model(car.getModele())
                .build();

    }
}
