package com.example.demo;

import jakarta.persistence.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;

@Entity
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reponse;
    private String reponse;
    private Long points;

    @ManyToOne
    @JoinColumn(name = "id_diagnostic")
    private Diagnostic diagnostic;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Questions question;



    public Questions getQuestions() {
        return question;
    }


    // Getter et setter pour la relation ManyToOne avec Diagnostic
    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Long getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(Long id_reponse) {
        this.id_reponse = id_reponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}
