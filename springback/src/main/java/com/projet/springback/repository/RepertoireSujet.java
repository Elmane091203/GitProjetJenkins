package com.projet.springback.repository;

import com.projet.springback.model.Sujet;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface RepertoireSujet extends CrudRepository<Sujet,Long> {
}
