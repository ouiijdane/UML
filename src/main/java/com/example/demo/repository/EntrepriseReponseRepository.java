package com.example.demo.repository;

import com.example.demo.Entreprise;
import com.example.demo.EntrepriseReponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrepriseReponseRepository extends JpaRepository<EntrepriseReponse, Long> {
    List<EntrepriseReponse> findByEntreprise(Entreprise entreprise);
}


