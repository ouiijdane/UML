package com.example.demo.controller;

import com.example.demo.CategorieQuestion;
import com.example.demo.Diagnostic;
import com.example.demo.Service.CategorieQuestionService;
import com.example.demo.Questions;
import com.example.demo.Service.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnostics")
public class DiagnosticController {

    private final DiagnosticService diagnosticService;
    private final CategorieQuestionService categorieQuestionService;

    @Autowired
    public DiagnosticController(DiagnosticService diagnosticService, CategorieQuestionService categorieQuestionService) {
        this.diagnosticService = diagnosticService;
        this.categorieQuestionService = categorieQuestionService;
    }

    @PostMapping("/calculate-total-score")
    public double calculateTotalScore(@RequestBody Diagnostic diagnostic) {
        // Appelez la méthode du service pour calculer le score total
        double totalScore = diagnosticService.calculateTotalScore(diagnostic);
        System.out.println("Total Score: " + totalScore);
        return totalScore;
    }

    @PostMapping("/calculate-category-score/{id_categorie}")
    public double calculateCategoryScore(@RequestBody Diagnostic diagnostic, @PathVariable Long id_categorie) {
        // Obtenez le nombre de points dans la catégorie spécifiée
        int categoryPoints = diagnosticService.calculatePointsInCategory(diagnostic, id_categorie);

        // Obtenez le nombre total de questions dans la catégorie spécifiée
        int categoryQuestions = categorieQuestionService.getNumberOfQuestionsInCategory(id_categorie);

        // Vérifiez si le nombre de questions est zéro pour éviter une division par zéro
        if (categoryQuestions == 0) {
            return 0.0; // Retournez 0.0 si le nombre de questions est zéro
        }

        // Calcul du score dans la catégorie spécifiée : nombre de points / nombre de questions
        double categoryScore = (double) categoryPoints / categoryQuestions;

        System.out.println("Category Score: " + categoryScore);
        return categoryScore;
    }

}
