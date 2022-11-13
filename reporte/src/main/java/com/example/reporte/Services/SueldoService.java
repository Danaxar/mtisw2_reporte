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
//        String url = "http://localhost:8085/sueldo/all/";
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
    public void printSueldo(SueldoModel sueldo){
        String salida = Integer.toString(sueldo.getId()) + " - " + sueldo.getRut() + "\n";
        salida = salida + "\tNombres: " + sueldo.getNombreEmpleado()+ "\n";
        salida = salida + "\tAnos de servicio: " + Integer.toString(sueldo.getYearsOfService())+ "\n";
        salida = salida + "\tSueldo fijo mensual: " + Integer.toString(sueldo.getSueldoFijoMensual())+ "\n";
        salida = salida + "\tBono anos de servicio: " + String.valueOf(sueldo.getBonoYearsOfService())+ "\n";
        salida = salida + "\tPago de horas extras: " + String.valueOf(sueldo.getPagoHorasExtras())+ "\n";
        salida = salida + "\tMonto descuentos: " + String.valueOf(sueldo.getMontoDescuentos())+ "\n";
        salida = salida + "\tSueldo Bruto: " + String.valueOf(sueldo.getSueldoBruto())+ "\n";
        salida = salida + "\tCotizacion Previsional: " + String.valueOf(sueldo.getCotizacionPrevisional())+ "\n";
        salida = salida + "\tCotizacion salud: " + String.valueOf(sueldo.getCotizacionSalud())+ "\n";
        salida = salida + "\tSueldo Final: " + Integer.toString(sueldo.getSueldoFinal())+ "\n";
        System.out.println(salida);
    }
}
