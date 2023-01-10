package com.projet.springback.controller;

import com.projet.springback.model.Etudiant;
import com.projet.springback.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EtudiantController {
    @Autowired
    private EtudiantService iEtudiant;

    @PostMapping("/ajoutE")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiant.ajouterEtudiant(etudiant);
    }
    @GetMapping("/etudiants")
    public List<Etudiant> listEtudiants()
    {
        return (List<Etudiant>) iEtudiant.listeEtudiants();
    }
}