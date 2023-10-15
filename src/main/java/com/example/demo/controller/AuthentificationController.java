package com.example.demo.controller;


import com.example.demo.Questions;
import com.example.demo.Service.DiagnosticService;
import com.example.demo.Service.QuestionService;
import com.example.demo.Service.UtilisateurService;
import com.example.demo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthentificationController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private DiagnosticService diagnosticService;

    @PostMapping("/authentifier")
    public ResponseEntity<String> authentifier(@RequestParam String nom, @RequestParam String password) {
        Utilisateur utilisateur = utilisateurService.authentifierUtilisateur(nom, password);
        if (nom == null || password == null || nom.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Le nom d'utilisateur ou le mot de passe ne peut pas être vide.", HttpStatus.BAD_REQUEST);
        }

        Utilisateur utilisateur1 = utilisateurService.authentifierUtilisateur(nom, password);
        if (utilisateur != null) {
            return new ResponseEntity<>("Authentification réussie.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nom d'utilisateur ou mot de passe incorrect.", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/questions")
    public List<Questions> getQuestions() {
        return questionService.getAllQuestions();
    }



}
