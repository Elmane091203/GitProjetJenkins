package com.projet.springback.service;

import com.projet.springback.model.Groupe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupeService {
    public List<Groupe> gener( int nb);
    public List<List<Groupe>> listDesGroupes();

}
