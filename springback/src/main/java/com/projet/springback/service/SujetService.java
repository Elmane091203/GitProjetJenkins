package com.projet.springback.service;

import com.projet.springback.model.Sujet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SujetService {
    public Sujet ajouterSujet(Sujet sujet);
    public List<Sujet> listeSujets();
}
