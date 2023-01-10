package com.projet.springback.service;

import com.projet.springback.model.Etudiant;
import com.projet.springback.model.Groupe;
import com.projet.springback.model.Sujet;
import com.projet.springback.repository.RepertoirEtudiant;
import com.projet.springback.repository.RepertoireSujet;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService {
    @Autowired
    public RepertoirEtudiant etudiantService;
    @Autowired
    public RepertoireSujet repertoireSujet;
    public static List<Etudiant> etudiant = new ArrayList<>();
    public static List<Sujet> sujets = new ArrayList<>();

    public List<Groupe> gener(int nb) {
        etudiant = (List<Etudiant>) etudiantService.findAll();
        sujets = (List<Sujet>) repertoireSujet.findAll();
        return genererLesGroupes(Math.min(sujets.size(), nb));
    }

    private @NotNull List<Groupe> genererLesGroupes(int nb) {
        List<Groupe>listGroupe = new ArrayList<>(nb);
        int fait = 1;
        int li = etudiant.size();
        try {
            for (int i = 0; i < nb; i++) {
                try {
                    List<Etudiant> membre = new ArrayList<>();
                    int nombreE = li / nb;
                    while (nombreE > 0) {
                        membre.add(randomEtud());
                        System.out.println(nombreE);
                        nombreE--;
                    }
                    listGroupe.add(new Groupe(membre, randomSuje()));
                    fait++;
                } catch (IndexOutOfBoundsException exception) {
                    break;
                }
            }

        } catch (IndexOutOfBoundsException exception) {
            int rest = nb - fait;
            if (rest == 1) {
                List<Etudiant> membre = new ArrayList<>();
                int nombreE = li / nb;
                while (nombreE > 0) {
                    membre.add(randomEtud());
                    System.out.println(nombreE);
                    nombreE--;
                }
                listGroupe.add(new Groupe(membre, randomSuje()));
            } else if (rest > 1) {

                for (int i = 0; i < rest; i++) {
                    List<Etudiant> membre = new ArrayList<>();
                    int nombreE = li / nb;
                    while (nombreE > 0) {
                        membre.add(randomEtud());
                        nombreE--;

                    }
                    listGroupe.add(new Groupe(membre, randomSuje()));
                }
            }
        }
        return listGroupe;
    }

    public @NotNull Etudiant randomEtud() {
        int nombreE = Math.max(etudiant.size(), 1);
        Etudiant e =(nombreE==1)?etudiant.get(0): etudiant.get((int) (1 + (Math.random() * (nombreE - 1))));
        etudiant.remove(e);
        return e;
    }

    private @NotNull Sujet randomSuje() {
        int nombreE = Math.max(sujets.size(), 1);
        Sujet s =(nombreE==1)?sujets.get(0): sujets.get((int) (1 + (Math.random() * (nombreE - 1))));
        sujets.remove(s);
        return s;
    }
}
