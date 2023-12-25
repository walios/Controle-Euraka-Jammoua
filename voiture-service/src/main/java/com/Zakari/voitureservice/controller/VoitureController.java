package com.elkastali.voitureservice.controller;


import com.elkastali.voitureservice.client.ClientRestService;
import com.elkastali.voitureservice.entities.CarResponse;
import com.elkastali.voitureservice.entities.Voiture;
import com.elkastali.voitureservice.repository.VoitureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.elkastali.voitureservice.service.carService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/car")
public class VoitureController {

    private final VoitureRepository voitureRepository;
    private final ClientRestService clientRestService;


    @Autowired
    private carService carService;


    @GetMapping
    public List<CarResponse> findAll(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable Long id) throws  Exception{

        return carService.findById(id);
    }

    @PostMapping
    public Voiture save(@RequestBody Voiture voiture){
        return voitureRepository.save(voiture);
    }
}
