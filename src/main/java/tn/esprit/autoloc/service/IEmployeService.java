package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entity.Employe;
import java.util.List;
import java.util.Optional;

public interface IEmployeService {
    Employe create(Employe employe);
    List<Employe> findAll();
    Optional<Employe> findById(Long id);
    Employe update(Employe employe);
    void delete(Long id);
}