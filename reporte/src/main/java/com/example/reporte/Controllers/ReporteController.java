package com.example.reporte.Controllers;

import com.example.reporte.Models.SueldoModel;
import com.example.reporte.Models.TokenInfo;
import com.example.reporte.Models.UserInfo;
import com.example.reporte.Services.JwtUtilService;
import com.example.reporte.Services.SueldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import java.util.List;

@RestController
@RequestMapping("/reporte")
public class ReporteController {

    @Autowired
    SueldoService sueldoService;

    @Autowired
    JwtUtilService jwtUtilService;

    @Autowired
    UserDetailsService usuarioDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/all")
    public ResponseEntity<List<SueldoModel>> getAll(){
        List<SueldoModel> salida = sueldoService.getAll();
        if(salida.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        for(int i = 0; i < salida.size(); i++){
            sueldoService.printSueldo(salida.get(i));
        }
        return ResponseEntity.ok(salida);
    }

    // Aqui se implementa la ciberseguridad
    @PostMapping("/autenticar")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody UserInfo userInfo) {
        // Papeado
        authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(
                        userInfo.getUsuario(),
                        userInfo.getClave()));

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(userInfo.getUsuario());
        final String jwt = jwtUtilService.generateToken(userDetails);
        TokenInfo tokenInfo = new TokenInfo(jwt);

        return ResponseEntity.ok(tokenInfo);
    }
}
