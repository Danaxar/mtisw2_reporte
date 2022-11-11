package com.example.reporte.Controllers;

import com.example.reporte.Models.SueldoModel;
import com.example.reporte.Services.SueldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reporte")
public class ReporteController {

    @Autowired
    SueldoService sueldoService;

    @GetMapping("/all")
    public ResponseEntity<List<SueldoModel>> getAll(){
        List<SueldoModel> salida = sueldoService.getAll();
        if(salida.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(salida);
    }
}
