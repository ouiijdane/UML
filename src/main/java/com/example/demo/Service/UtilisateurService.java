package com.example.demo.Service;

import com.example.demo.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur authentifierUtilisateur(String nom, String password) {
        return utilisateurRepository.findByNomAndPassword(nom, password);
    }
}

