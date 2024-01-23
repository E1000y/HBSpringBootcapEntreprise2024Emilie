package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.Platform;
import fr.EmiliePaniagua.poec.exam.repository.PlatformRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlatformService implements DAOServiceInterface<Platform> {

    private PlatformRepository platformRepository;
    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public Platform findById(Long id) {
        Optional<Platform> platformOptional = platformRepository.findById(id);
        return platformOptional.get();
    }
}