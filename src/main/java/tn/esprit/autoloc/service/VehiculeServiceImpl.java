package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entity.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.repository.IEquipementRepository;
import tn.esprit.autoloc.Entity.Equipement;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final IEquipementRepository equipementRepository;

    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Optional<Vehicule> findById(Long id) {
        return vehiculeRepository.findById(id);
    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(Long id) {
        vehiculeRepository.deleteById(id);
    }


    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule non trouvé"));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Équipement non trouvé"));

        vehicule.getEquipements().add(equipement);

        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule non trouvé"));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Équipement non trouvé"));

        vehicule.getEquipements().remove(equipement);

        return vehiculeRepository.save(vehicule);
    }

    // Question 1
    @Scheduled(fixedRate = 60000, initialDelay = 5000)
    public void actualiserEtatVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        System.out.println("\n=== Question1 : Actualisation des vehicules");
        System.out.println("Nbr totale de vehicule:" + vehicules.size());
        System.out.println("date d actualisation : " + LocalDateTime.now());
        System.out.println("***********************************************");
    }
    // Question 3
    @Scheduled(cron = "0 0 9 * * MON")
    public void genererRapportVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        System.out.println("\n=== Question3 : generer Rapport Vehicules");
        System.out.println("Nbr totale de vehicule:" + vehicules.size());
        System.out.println("Date et heure de génération : " + LocalDateTime.now());
        System.out.println("***********************************************");
    }
}

