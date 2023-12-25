package com.elkastali.voitureservice.entities;


import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Client {

    private Long id;
    private String nom;
    private Float age;
}
