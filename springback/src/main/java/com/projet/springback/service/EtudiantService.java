package com.projet.springback.service;

import com.projet.springback.model.Etudiant;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface EtudiantService {
    public Etudiant ajouterEtudiant(Etudiant e);
    public List<Etudiant> listeEtudiants();
}
