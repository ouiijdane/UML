package com.example.demo.Service;

import com.example.demo.CategorieQuestion;
import com.example.demo.Questions;
import com.example.demo.repository.CategorieQuestionRepository;
import com.example.demo.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private CategorieQuestionRepository categorieQuestionRepository; // Inject CategorieQuestionRepository

    @Override
    public List<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }

    @Override
    public List<Questions> getQuestionsByCategory(Long id_categorie) {
        return null;
    }

    public List<Questions> getAllQuestionsWithReponses() {
        return null;
    }


    public int getTotalQuestions() {
        return (int) questionsRepository.count();
    }



}