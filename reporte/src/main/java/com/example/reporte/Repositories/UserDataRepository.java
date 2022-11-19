package com.example.reporte.Repositories;

import com.example.reporte.Entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {
    UserData findByUsuario(String username);
}
