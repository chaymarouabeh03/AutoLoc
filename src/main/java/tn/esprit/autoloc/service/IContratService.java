package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entity.Contrat;
import java.util.List;
import java.util.Optional;

public interface IContratService {
    Contrat create(Contrat contrat);
    List<Contrat> findAll();
    Optional<Contrat> findById(Long id);
    Contrat update(Contrat contrat);
    void delete(Long id);
}