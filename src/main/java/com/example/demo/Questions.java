package com.example.demo;

import jakarta.persistence.*;
import jdk.jfr.Category;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "questions")
public class Questions implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_question;
    private String nom_question;


    public Long getId_question() {
        return id_question;
    }


    @OneToMany(mappedBy = "question")
    private List<Reponse> reponses;


    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private CategorieQuestion categorie;

    @OneToOne
    @JoinColumn(name = "id_reponse")
    private Reponse reponse;

    @ManyToOne
    @JoinColumn(name = "id_diagnostic")
    private Diagnostic diagnostic;




    public void setId_question(Long id_question) {
        this.id_question = id_question;
    }

    public String getNom_question() {
        return nom_question;
    }

    public void setNom_question(String nom_question) {
        this.nom_question = nom_question;
    }
}
