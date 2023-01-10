package com.projet.springback.model;


import java.util.List;

public class Groupe {
    private String nb;
    private List<Etudiant> membreG;
    private Sujet sujet;

    public Groupe(List<Etudiant> membreG, Sujet sujet) {
        this.membreG = membreG;
        this.sujet = sujet;
    }

    public List<Etudiant> getMembreG() {
        return membreG;
    }

    public void setMembreG(List<Etudiant> membreG) {
        this.membreG = membreG;
    }

    public Sujet getSujet() {
        return sujet;
    }

    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }

    public String getNb() {
        return nb;
    }

    public void setNb(String nb) {
        this.nb = nb;
    }
}
