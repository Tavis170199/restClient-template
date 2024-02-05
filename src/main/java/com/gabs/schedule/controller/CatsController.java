package com.gabs.schedule.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabs.schedule.Util.Util;
import com.gabs.schedule.dto.Fact;
import com.gabs.schedule.models.BreedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.logging.Logger;

@RestController
public class CatsController {

    static final Logger LOGGER =
            Logger.getLogger(CatsController.class.getName());

    ObjectMapper objectMapper = new ObjectMapper();


    RestClient restClient = RestClient.create();

   // @Scheduled(fixedRate = 5000)
    @GetMapping("/facts")
    public  ResponseEntity<Fact> helloWorldSchedule() {
        return restClient.get()
                .uri(Util.URI_CATS + "/fact")
                .retrieve()
                .toEntity(Fact.class);
    }

    @GetMapping("/breeds")
    public ResponseEntity<BreedModel> breedSchedule() {
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Util.URI_CATS + "/breeds")
                .queryParam("limit", 4).build();

       BreedModel breed = restClient.get()
                .uri(builder.toUriString())
                .exchange((request, response) -> objectMapper.readValue(response.getBody(), new TypeReference<>() {
                }));
        return ResponseEntity.ok(breed);
    }
}
