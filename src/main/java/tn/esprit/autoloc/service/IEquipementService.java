package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entity.Equipement;
import java.util.List;
import java.util.Optional;

public interface IEquipementService {
    Equipement create(Equipement equipement);
    List<Equipement> findAll();
    Optional<Equipement> findById(Long id);
    Equipement update(Equipement equipement);
    void delete(Long id);
}