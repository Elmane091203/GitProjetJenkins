package com.projet.springback.service;

import com.projet.springback.model.Sujet;
import com.projet.springback.repository.RepertoireSujet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SujetServiceImpl implements SujetService{
    @Autowired
    private RepertoireSujet sujet;
    @Autowired
    private RepertoireSujet repertoireSujet;

    @Override
    public Sujet ajouterSujet(Sujet sujet) {
        return repertoireSujet.save(sujet);
    }

    @Override
    public List<Sujet> listeSujets() {
        return (List<Sujet>) sujet.findAll();
    }
}
