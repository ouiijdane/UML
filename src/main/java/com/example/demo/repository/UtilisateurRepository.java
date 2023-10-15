package com.example.demo.repository;

import com.example.demo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query("SELECT u FROM Utilisateur u WHERE u.nom = :nom AND u.password = :password")
    Utilisateur findByNomAndPassword(@Param("nom") String nom, @Param("password") String password);
}
