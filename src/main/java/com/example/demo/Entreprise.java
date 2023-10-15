package com.example.demo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entreprise;

    private String adresse;
    private String nom_entreprise;
    private String tel;



    public Long getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(Long id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

