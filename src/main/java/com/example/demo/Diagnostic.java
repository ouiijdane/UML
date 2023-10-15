package com.example.demo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Diagnostic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_diagnostic;
    private String commentaire;

    @OneToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "diagnostic") // Ceci établit la relation OneToMany avec la classe Reponse
    private List<Reponse> reponses;

    // Getter et setter pour la liste de réponses
    public List<Reponse> getReponses() {
        return reponses;
    }
    // Méthode pour calculer le score
    public double calculerScore() {
        long totalPoints = 0;

        // Parcourir la liste des réponses et additionner les points
        for (Reponse reponse : reponses) {
            totalPoints += reponse.getPoints();
        }

        // Calculer le score en pourcentage
        double score = (double) totalPoints * 100 / 30;
        return score;
    }




    public Long getId_diagnostic() {
        return id_diagnostic;
    }

    public void setId_diagnostic(Long id_diagnostic) {
        this.id_diagnostic = id_diagnostic;
    }



    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
