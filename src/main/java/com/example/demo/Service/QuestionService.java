package com.example.demo.Service;

import com.example.demo.Questions;

import java.util.List;

public interface QuestionService {
    List<Questions> getAllQuestions();
    List<Questions> getQuestionsByCategory(Long id_categorie);

    int getTotalQuestions();
}


