package com.example.demo.Service;

import com.example.demo.CategorieQuestion;
import com.example.demo.Questions;
import com.example.demo.repository.CategorieQuestionRepository;
import com.example.demo.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieQuestionServiceImpl implements CategorieQuestionService {

    private final CategorieQuestionRepository categorieQuestionRepository;
    private final QuestionsRepository questionsRepository;

    @Autowired
    public CategorieQuestionServiceImpl(CategorieQuestionRepository categorieQuestionRepository, QuestionsRepository questionsRepository) {
        this.categorieQuestionRepository = categorieQuestionRepository;
        this.questionsRepository = questionsRepository;
    }

    @Override
    public List<CategorieQuestion> getAllCategorieQuestion() {
        return categorieQuestionRepository.findAll();
    }

    @Override
    public List<Questions> getQuestionsByCategory(Long categoryId) {
        CategorieQuestion categorie = categorieQuestionRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Catégorie de question non trouvée"));

        return questionsRepository.findByCategorie(categorie);
    }

    @Override
    public int getNumberOfQuestionsInCategory(Long categoryId) {
        // Implémentez la logique pour récupérer le nombre de questions dans la catégorie spécifiée
        // Utilisez votre questionsRepository ou toute autre méthode appropriée pour cela
        return 0; // Mettez votre logique ici pour récupérer le nombre de questions
    }
}
