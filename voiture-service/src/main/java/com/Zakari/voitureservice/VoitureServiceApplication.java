package com.elkastali.voitureservice;

import com.elkastali.voitureservice.client.ClientRestService;
import com.elkastali.voitureservice.entities.Voiture;
import com.elkastali.voitureservice.repository.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class VoitureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureServiceApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    //@Bean
    //CommandLineRunner commandLineRunner (VoitureRepository voitureRepository, ClientRestService clientRestService){

    //    return args -> {
      //     voitureRepository.save(Voiture.builder()
        //                   .marque("Mercedes")
          //                  .modele("Class A")
            //                .matricule("123456")
              //              .clientId(1L)
                //            .client(clientRestService.findById(1L))
                  //          .build());


            //voitureRepository.save(Voiture.builder()
              //      .marque("Audi")
                //    .modele("Class B")
                  //  .matricule("TC940")
                    //.clientId(2L)
                    //.client(clientRestService.findById(2L))
                    //.build());
       // };
   // }
}
