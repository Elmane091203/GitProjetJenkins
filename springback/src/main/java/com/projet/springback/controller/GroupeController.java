package com.projet.springback.controller;

import com.projet.springback.model.Groupe;
import com.projet.springback.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class GroupeController {
    @Autowired
    private GroupeService groupeService;
    @PostMapping("/groupe")
    public List<Groupe> genererLesGroupes(@RequestBody String groupe) {
        return groupeService.gener(Integer.parseInt(groupe));
    }

    @GetMapping("/groupes")
    public  List<List<Groupe>> listDesGroupes(){
        return groupeService.listDesGroupes();
    }
}
