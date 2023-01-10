package com.projet.springback.controller;

import com.projet.springback.model.Sujet;
import com.projet.springback.repository.RepertoireSujet;
import com.projet.springback.service.EtudiantService;
import com.projet.springback.service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class SujetController {
    @Autowired
    private SujetService sujet;

    @GetMapping("/sujets")
    public List<Sujet> listeSujets(){
       return sujet.listeSujets();
    }
    @PostMapping("/ajoutS")
    public Sujet ajoutS(@RequestBody Sujet s){
       return sujet.ajouterSujet(s);
    }
}
