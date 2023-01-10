package com.projet.springback.service;

import com.projet.springback.model.Etudiant;
import com.projet.springback.repository.RepertoirEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantServiceImpl implements EtudiantService{
    @Autowired
    private RepertoirEtudiant et;
    @Override
    public Etudiant ajouterEtudiant(Etudiant e) {
        return et.save(e);
    }

    @Override
    public List<Etudiant> listeEtudiants() {
        return (List<Etudiant>) et.findAll();
    }
}
