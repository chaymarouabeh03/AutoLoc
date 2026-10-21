package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entity.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    Reservation create(Reservation reservation);
    List<Reservation> findAll();
    Optional<Reservation> findById(Long id);
    Reservation update(Reservation reservation);
    void delete(Long id);
}