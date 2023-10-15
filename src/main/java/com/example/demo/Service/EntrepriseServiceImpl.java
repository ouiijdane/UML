package com.example.demo.Service;

import com.example.demo.Entreprise;
import com.example.demo.EntrepriseReponse;
import com.example.demo.Questions;
import com.example.demo.Reponse;
import com.example.demo.repository.EntrepriseReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {

    private final EntrepriseReponseRepository entrepriseReponseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseReponseRepository entrepriseReponseRepository) {
        this.entrepriseReponseRepository = entrepriseReponseRepository;
    }

    @Override
    public List<EntrepriseReponse> getReponsesByEntreprise(Entreprise entreprise) {
        // Assuming getId_entreprise() is a non-static method in the Entreprise class
        long id_entreprise = entreprise.getId_entreprise();
        return entrepriseReponseRepository.findByEntreprise(entreprise);
    }


    @Override
    public int calculateScoreByEntreprise(Entreprise entreprise) {
        List<EntrepriseReponse> reponses = getReponsesByEntreprise(entreprise);
        int score = 0;
        for (EntrepriseReponse reponse : reponses) {
            score += reponse.getReponse().getPoints();
        }
        return score;
    }

    @Override
    public void saveEntrepriseReponse(Entreprise entreprise, Questions question, Reponse reponse) {
        EntrepriseReponse entrepriseReponse = new EntrepriseReponse();
        entrepriseReponse.setEntreprise(entreprise);
        entrepriseReponse.setQuestion(question);
        entrepriseReponse.setReponse(reponse);
        entrepriseReponseRepository.save(entrepriseReponse);
    }
    @Override
    public Entreprise getEntrepriseParId(Long id_entreprise) {
        Optional<Entreprise> entreprise = entrepriseReponseRepository.findById(id_entreprise).map(EntrepriseReponse::getEntreprise);
        return entreprise.orElse(null);
    }


}
