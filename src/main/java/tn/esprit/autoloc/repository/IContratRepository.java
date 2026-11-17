package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entity.Contrat;

public interface IContratRepository extends JpaRepository<Contrat, Long> {
}