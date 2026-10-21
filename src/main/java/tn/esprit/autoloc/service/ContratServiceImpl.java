package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entity.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final IContratRepository contratRepository;

    @Override
    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public Optional<Contrat> findById(Long id) {
        return contratRepository.findById(id);
    }

    @Override
    public Contrat update(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void delete(Long id) {
        contratRepository.deleteById(id);
    }
}