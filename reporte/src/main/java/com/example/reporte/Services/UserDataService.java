package com.example.reporte.Services;

import com.example.reporte.Entity.UserData;
import com.example.reporte.Repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {
    @Autowired
    UserDataRepository userDataRepository;
    public List<UserData> getAll() {return userDataRepository.findAll();}
    public UserData getUserById(int id){return userDataRepository.findById(id).orElse(null);}
    public UserData save(UserData userData){
        UserData userDataNew = userDataRepository.save(userData);
        return userDataNew;
    }
}
