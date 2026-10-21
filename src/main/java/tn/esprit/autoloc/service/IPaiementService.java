package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entity.Paiement;
import java.util.List;
import java.util.Optional;

public interface IPaiementService {
    Paiement create(Paiement paiement);
    List<Paiement> findAll();
    Optional<Paiement> findById(Long id);
    Paiement update(Paiement paiement);
    void delete(Long id);
}