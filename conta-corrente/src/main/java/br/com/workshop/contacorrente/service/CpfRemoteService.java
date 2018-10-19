package br.com.workshop.contacorrente.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CpfRemoteService {

   private final RestTemplate restTemplate;

   @Value("${service.spring-boot-demo.url}")
   private String remoteUrl;

   public CpfRemoteService(RestTemplate restTemplate) {
       this.restTemplate = restTemplate;
   }

   public Optional<Map<String, String>> findNomeByCpf(String cpf) {
       final ResponseEntity<Map> response = restTemplate.getForEntity(remoteUrl, Map.class, cpf);

       if (!response.getStatusCode().equals(HttpStatus.OK)) {
           return Optional.empty();
       }

       return Optional.of(response.getBody());
   }
}
