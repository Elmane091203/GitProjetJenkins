package com.projet.springback.service;

import com.projet.springback.model.Etudiant;
import com.projet.springback.model.Groupe;
import com.projet.springback.model.Sujet;
import com.projet.springback.repository.RepertoirEtudiant;
import com.projet.springback.repository.RepertoireGroupe;
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
    @Autowired
    public RepertoireGroupe repertoireGroupe;

    public static List<Etudiant> etudiant = new ArrayList<>();
    public static List<Sujet> sujets = new ArrayList<>();

    public List<Groupe> gener(int nb) {
        etudiant = (List<Etudiant>) etudiantService.findAll();
        sujets = (List<Sujet>) repertoireSujet.findAll();
        return genererLesGroupes(Math.min(sujets.size(), nb));
    }

    @Override
    public List<List<Groupe>> listDesGroupes() {
        List<List<Groupe>> g = new ArrayList<>();
        List<Groupe> basG = (List<Groupe>) repertoireGroupe.findAll();
        for (int i = 0; i < basG.size(); i++) {
            List<Groupe> groups = new ArrayList<>();
            try {
                for (int j = i; j < basG.size(); j++) {
                    String[] listE = diviser(basG.get(j).getMembre().split("|"), "|");
                    List<Etudiant> membreG = new ArrayList<>();
                    int k;
                    try {
                        for (k = 0; k < listE.length; k++) {
                            if (etudiantService.findById(Long.parseLong(listE[k])).isPresent())
                                membreG.add(etudiantService.findById(Long.parseLong(listE[k])).get());

                        }
                    }
                    catch (IndexOutOfBoundsException e) {

                        for (k = listE.length - membreG.size(); k < listE.length; k++) {
                            if (etudiantService.findById(Long.parseLong(listE[k])).isPresent())
                                membreG.add(etudiantService.findById(Long.parseLong(listE[k])).get());
                        }


                    }
                    groups.add(new Groupe(membreG, repertoireSujet.findById(basG.get(j).getIdS()).get()));
                    if (basG.get(j).getIdCreation() != basG.get(j + 1).getIdCreation()) {
                        i = j ;
                        break;
                    }
                }
            } catch (IndexOutOfBoundsException exception) {
                break;
            }

            g.add(groups);
        }

        return g;
    }

    private @NotNull List<Groupe> genererLesGroupes(int nb) {
        Groupe groupe = new Groupe((repertoireGroupe.count() == 0) ? 1 : repertoireGroupe.findById(repertoireGroupe.count()).get().getIdCreation());
        List<Groupe> listGroupe = new ArrayList<>(nb);
        int fait = 1;
        int li = etudiant.size();
        try {
            for (int i = 0; i < nb; i++) {
                try {
                    List<Etudiant> membre = new ArrayList<>();
                    int nombreE = li / nb;
                    while (nombreE > 0) {
                        membre.add(randomEtud());
                        nombreE--;
                    }
                    Groupe g1 = new Groupe(membre, randomSuje());
                    listGroupe.add(g1);
                    repertoireGroupe.save(g1);
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
                    nombreE--;
                }
                Groupe g1 = new Groupe(membre, randomSuje());
                listGroupe.add(g1);
                repertoireGroupe.save(g1);
            } else if (rest > 1) {

                for (int i = 0; i < rest; i++) {
                    List<Etudiant> membre = new ArrayList<>();
                    int nombreE = li / nb;
                    while (nombreE > 0) {
                        membre.add(randomEtud());
                        nombreE--;

                    }
                    Groupe g1 = new Groupe(membre, randomSuje());
                    listGroupe.add(g1);
                    repertoireGroupe.save(g1);
                }
            }
        }
        return listGroupe;
    }

    public @NotNull Etudiant randomEtud() {
        int nombreE = etudiant.size();
        Etudiant e = etudiant.get((int) (0 + (Math.random() * (nombreE))));
        etudiant.remove(e);
        return e;
    }

    private @NotNull Sujet randomSuje() {
        int nombreE = sujets.size();
        Sujet s = sujets.get((int) (0 + (Math.random() * (nombreE))));
        sujets.remove(s);
        return s;
    }

    private @NotNull int taille(String[] string, String c) {
        int cout = 0;
        for (String s : string) {
            if (s.equals(c))
                cout++;
        }
        return cout;
    }

    private @NotNull String[] diviser(String[] string, String c) {
        String[] res = new String[taille(string, c)];
        int i = 0;
        for (int j = 0; j < taille(string, c); j++) {
            res[j] = "";
        }
        for (String s :
                string) {
            if (!s.equals(c))
                res[i] += s;
            else
                i++;
        }
        return res;
    }
}
