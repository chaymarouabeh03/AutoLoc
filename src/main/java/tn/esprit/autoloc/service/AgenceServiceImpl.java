package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entity.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.repository.IEmployeRepository;
import tn.esprit.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.Entity.Employe;
import tn.esprit.autoloc.Entity.Vehicule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;
    private final IEmployeRepository employeRepository;
    private final IVehiculeRepository vehiculeRepository;

    @Override
    public Agence create(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    @Override
    public Optional<Agence> findById(Long id) {
        return agenceRepository.findById(id);
    }

    @Override
    public Agence update(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void delete(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));

        employe.setAgence(null);

        return employeRepository.save(employe);
    }

    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));

        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence non trouvée"));

        employe.setAgence(agence);

        return employeRepository.save(employe);
    }

    @Override
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        Agence agenceSauvegardee = agenceRepository.save(agence);

        if (agence.getVehicules() != null) {
            for (Vehicule vehicule : agence.getVehicules()) {
                vehicule.setAgence(agenceSauvegardee);

                vehiculeRepository.save(vehicule);
            }
        }

        return agenceSauvegardee;
    }


    // Question 2
    @Scheduled(fixedDelay = 2, timeUnit = TimeUnit.MINUTES)
    public void suivreNombreAgences(){
        List<Agence> agences = agenceRepository.findAll();
        System.out.println("\n=== Question2 : Suivre Nombre Agences");
        System.out.println("nbr total d'agences enregistrées:" + agences.size());
        System.out.println("date et l'heure de chaque vérification : " + LocalDateTime.now());
        System.out.println("***********************************************");
    }
}

