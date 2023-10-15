package com.example.demo.controller;

import com.example.demo.Entreprise;
import com.example.demo.EntrepriseReponse;
import com.example.demo.Questions;
import com.example.demo.Reponse;
import com.example.demo.Service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entreprise-reponses")
public class EntrepriseReponseController {

    private final EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseReponseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping("/{id_entreprise}")
    public ResponseEntity<List<EntrepriseReponse>> getReponsesByEntreprise(@PathVariable Long id_entreprise) {
        Entreprise entreprise = entrepriseService.getEntrepriseParId(id_entreprise);
        if (id_entreprise == null) {
            return ResponseEntity.notFound().build();
        }

        List<EntrepriseReponse> entrepriseReponses = entrepriseService.getReponsesByEntreprise(entreprise);
        return ResponseEntity.ok(entrepriseReponses);
    }

    @PostMapping("/")
    public void saveEntrepriseReponse(@RequestBody EntrepriseReponse entrepriseReponse) {
        // Enregistrez la réponse de l'entreprise dans la base de données
        // Extrait les objets entreprise, Questions et Reponse de l'objet EntrepriseReponse
        Entreprise entreprise = entrepriseReponse.getEntreprise();
        Questions question = entrepriseReponse.getQuestion();
        Reponse reponse = entrepriseReponse.getReponse();
        entrepriseService.saveEntrepriseReponse(entreprise, question, reponse);
    }
}

