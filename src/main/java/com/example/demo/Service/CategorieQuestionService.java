package com.example.demo.Service;

import com.example.demo.CategorieQuestion;
import com.example.demo.Questions;
import java.util.List;
public interface CategorieQuestionService {
    List<CategorieQuestion> getAllCategorieQuestion();
    List<Questions> getQuestionsByCategory(Long categoryId);
    int getNumberOfQuestionsInCategory(Long categoryId);

}
