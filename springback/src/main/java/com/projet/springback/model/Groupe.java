package com.projet.springback.model;


import com.projet.springback.repository.RepertoireGroupe;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name = "groupe_table")
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long idCreation;
    private String membre;
    private Long idS;
    @Transient
    private Sujet sujet;
    @Transient
    private String nb;
    @Transient
    private List<Etudiant> membreG;
    @Transient
    @Autowired
    private RepertoireGroupe repertoireGroupe;
    @Transient
    private static Long idCreationAuto ;

    public Groupe(Long dernierId ) {
        Groupe.idCreationAuto = dernierId;
        Groupe.idCreationAuto++;
    }

    public Groupe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Groupe(List<Etudiant> membreG, Sujet sujet) {
        this.membreG = membreG;
        this.sujet = sujet;
        this.membre= "";
        for (Etudiant etudiant:membreG) {
            this.membre+=etudiant.getId().toString()+"|";
        }
        this.idS=sujet.getId();
        this.idCreation = idCreationAuto;

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

    public Long getIdCreation() {
        return idCreation;
    }

    public void setIdCreation(Long idCreation) {
        this.idCreation = idCreation;
    }

    public String getMembre() {
        return membre;
    }

    public void setMembre(String membre) {
        this.membre = membre;
    }

    public Long getIdS() {
        return idS;
    }

    public void setIdS(Long idS) {
        this.idS = idS;
    }

}
