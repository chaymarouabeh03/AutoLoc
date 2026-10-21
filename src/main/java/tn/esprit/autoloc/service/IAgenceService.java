package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entity.Agence;
import java.util.List;
import java.util.Optional;

public interface IAgenceService {
    Agence create(Agence agence);
    List<Agence> findAll();
    Optional<Agence> findById(Long id);
    Agence update(Agence agence);
    void delete(Long id);
}