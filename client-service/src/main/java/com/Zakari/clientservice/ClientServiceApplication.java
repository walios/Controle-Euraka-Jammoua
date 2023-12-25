package com.elkastali.clientservice;

import com.elkastali.clientservice.entities.Client;
import com.elkastali.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {

            clientRepository.save(new Client(Long.parseLong("1"), "Aziz Zakari", Float.parseFloat("63")));
            clientRepository.save(new Client(Long.parseLong("2"), "Younes Zakari", Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("3"), "Anas Zakari", Float.parseFloat("23")));

        };
    }

    //@Bean
    // CommandLineRunner commandLineRunner(ClientRepository clientRepository){
    //return args -> {
    //    clientRepository.save(Client.builder()
    //                                     .nom("Zakari")
    //                                     .prenom("Anas")
    //                                     .age(22F)
    //                                  .build());
    //
    //    clientRepository.save(Client.builder()
    //                                    .nom("Zakari")
    //                                     .prenom("Younes")
    //                                      .age(22F)
    //                                   .build());
    //};
    //}
    }
