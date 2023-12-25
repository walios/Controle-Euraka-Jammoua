package com.elkastali.voitureservice.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class CarResponse {
    private Long id;
    private String brand;
    private String model;
    private String matricule;
    private  Client client;
}

