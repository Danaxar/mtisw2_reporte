package com.example.reporte.Services;

import com.example.reporte.Models.SueldoModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SueldoService {
    @Autowired
    RestTemplate restTemplate;

    public List<SueldoModel> getAll(){
        System.out.println("SueldoService: Obteniendo sueldos...");
        String url = "http://sueldo-microservice/sueldo/all/";
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class);
        System.out.println("request terminado.");
        Object[] records = response.getBody();
        if(records == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.stream(records)
                .map(data -> mapper.convertValue(data, SueldoModel.class))
                .collect(Collectors.toList());
    }
}
