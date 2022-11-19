package com.example.reporte.Services;

import com.example.reporte.Entity.UserData;
import com.example.reporte.Repositories.UserDataRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

public class UsuarioDetailsService implements UserDetailsService {
    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserData userData = userDataRepository.findByUsuario(username);

        if (userData != null) {
            User.UserBuilder userBuilder = User.withUsername(username);
            String encryptedPassword = userData.getClave();
            var rol = userData.getRol();
            userBuilder.password(encryptedPassword);
            userBuilder.roles(rol);
            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException(username);
        }

    }
}
