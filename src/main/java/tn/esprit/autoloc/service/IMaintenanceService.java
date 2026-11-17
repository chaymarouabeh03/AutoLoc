package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entity.Maintenance;
import java.util.List;
import java.util.Optional;

public interface IMaintenanceService {
    Maintenance create(Maintenance maintenance);
    List<Maintenance> findAll();
    Optional<Maintenance> findById(Long id);
    Maintenance update(Maintenance maintenance);
    void delete(Long id);
}