package com.projet.springback.repository;

import com.projet.springback.model.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepertoirEtudiant extends CrudRepository<Etudiant,Long> {
}
