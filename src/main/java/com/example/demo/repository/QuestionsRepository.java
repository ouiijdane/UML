package com.example.demo.repository;

import com.example.demo.CategorieQuestion;
import com.example.demo.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByCategorie(CategorieQuestion category);
    List<Questions> findByCategorieAndReponsesIsNotNull(CategorieQuestion category);
    long count();
    // Ajoutez la méthode pour récupérer toutes les questions
    List<Questions> findAll();
}

