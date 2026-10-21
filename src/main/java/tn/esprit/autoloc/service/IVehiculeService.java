package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entity.Vehicule;
import java.util.List;
import java.util.Optional;

public interface IVehiculeService {
    Vehicule create(Vehicule vehicule);
    List<Vehicule> findAll();
    Optional<Vehicule> findById(Long id);
    Vehicule update(Vehicule vehicule);
    void delete(Long id);
}