package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entity.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;

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
}