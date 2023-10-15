package com.example.demo.Service;

import com.example.demo.Diagnostic;
import com.example.demo.Reponse;
import com.example.demo.CategorieQuestion;
import com.example.demo.Questions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticService {

    private final CategorieQuestionService categorieQuestionService;

    public DiagnosticService(CategorieQuestionService categorieQuestionService) {
        this.categorieQuestionService = categorieQuestionService;
    }

    public double calculateTotalScore(Diagnostic diagnostic) {
        int totalPoints = calculateTotalPoints(diagnostic);
        int totalQuestions = getTotalQuestions(diagnostic);
        System.out.println("Total Points: " + totalPoints);
        System.out.println("Total Questions: " + totalQuestions);
        return calculateScore(totalPoints, totalQuestions);
    }


    public double calculateCategoryScore(Diagnostic diagnostic, Long id_categorie) {
        int totalQuestions = getTotalQuestions(diagnostic);
        int categoryPoints = calculatePointsInCategory(diagnostic, id_categorie);
        int categoryQuestions = categorieQuestionService.getNumberOfQuestionsInCategory(id_categorie);
        return calculateScore(categoryPoints, categoryQuestions);
    }


    private double calculateScore(int totalPoints, int totalQuestions) {
        System.out.println("Total Points Inside: " + totalPoints);
        System.out.println("Total Questions Inside: " + totalQuestions);
        return totalQuestions != 0 ? (double) totalPoints / totalQuestions : 0.0;
    }


    public int calculateTotalPoints(Diagnostic diagnostic) {
        int totalPoints = 0;
        for (Reponse reponse : diagnostic.getReponses()) {
            System.out.println("Calculating Points for Réponse - Points : " + reponse.getPoints());
            totalPoints += reponse.getPoints();
        }
        return totalPoints;
    }


    public int getTotalQuestions(Diagnostic diagnostic) {
        int totalQuestions = 0;
        // Obtenez les réponses du diagnostic
        List<Reponse> reponses = diagnostic.getReponses();

        // Parcourez les réponses pour compter le nombre total de questions
        for (Reponse reponse : reponses) {
            // Supposez que chaque réponse a une référence à une question
            Questions question = reponse.getQuestions();
            // Incrémentez le total des questions
            totalQuestions++;
        }

        return totalQuestions;
    }


    public int calculatePointsInCategory(Diagnostic diagnostic, Long id_categorie) {
        int categoryPoints = 0;
        // Obtenez les questions dans la catégorie spécifiée
        List<Questions> questions = categorieQuestionService.getQuestionsByCategory(id_categorie);

        // Parcourez les réponses du diagnostic et calculez les points dans la catégorie spécifiée
        for (Questions question : questions) {
            for (Reponse reponse : diagnostic.getReponses()) {
                if (reponse.getQuestions().getId_question().equals(question.getId_question())) {
                    categoryPoints += reponse.getPoints();
                    break;
                }
            }
        }

        return categoryPoints;
    }

}
