package com.example.demo.controller;
import com.example.demo.Questions;
import com.example.demo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionsController {
    private final QuestionService questionService; // Utilisez le nom correct du service ici

    @Autowired
    public QuestionsController(QuestionService questionService) { // Utilisez le nom correct du service ici
        this.questionService = questionService; // Utilisez le nom correct du service ici
    }

    @GetMapping("/total")
    public int getTotalQuestions() {
        int totalQuestions = questionService.getTotalQuestions();
        System.out.println("Total Questions: " + totalQuestions);
        return totalQuestions;
    }
}


