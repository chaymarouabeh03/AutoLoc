package tn.esprit.autoloc.service;


import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.Entity.Agence;
import tn.esprit.autoloc.Entity.Employe;

public interface IAgenceService {
    Agence create(Agence agence);
    List<Agence> findAll();
    Optional<Agence> findById(Long id);
    Agence update(Agence agence);
    void delete(Long id);


    Employe desaffecterEmploye(Long idEmploye);
    Employe affecterEmploye(Long idEmploye, Long idAgence);

    Agence ajouterAgenceEtAffecterVehicules(Agence agence);

}



