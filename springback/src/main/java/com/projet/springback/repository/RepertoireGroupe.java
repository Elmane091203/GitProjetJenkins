package com.projet.springback.repository;

import com.projet.springback.model.Groupe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepertoireGroupe extends CrudRepository<Groupe,Long> {
}
