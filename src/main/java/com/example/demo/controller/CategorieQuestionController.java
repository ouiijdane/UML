package com.example.demo.controller;

import com.example.demo.CategorieQuestion;
import com.example.demo.Service.CategorieQuestionService;
import com.example.demo.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieQuestionController {
    private final CategorieQuestionService CategorieQuestionService;

    @Autowired
    public CategorieQuestionController(CategorieQuestionService categorieQuestionService) {
        this.CategorieQuestionService = categorieQuestionService;
    }

    @GetMapping("/")
    public List<CategorieQuestion> getAllCategories() {
        return CategorieQuestionService.getAllCategorieQuestion();
    }

    @GetMapping("/{id_categorie}/questions")
    public List<Questions> getQuestionsByCategory(@PathVariable Long id_categorie) {
        return CategorieQuestionService.getQuestionsByCategory(id_categorie);
    }
}
