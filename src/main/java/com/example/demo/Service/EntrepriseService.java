package com.example.demo.Service;

import com.example.demo.Entreprise;
import com.example.demo.EntrepriseReponse;
import com.example.demo.Questions;
import com.example.demo.Reponse;

import java.util.List;

public interface EntrepriseService {
    List<EntrepriseReponse> getReponsesByEntreprise(Entreprise entreprise);
    int calculateScoreByEntreprise(Entreprise entreprise);
    Entreprise getEntrepriseParId(Long id_entreprise);
    void saveEntrepriseReponse(Entreprise entreprise, Questions question, Reponse reponse);
}

