package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.Gamer;
import fr.EmiliePaniagua.poec.exam.repository.GamerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GamerService implements DAOServiceInterface<Gamer> {

    private GamerRepository gamerRepository;
    @Override
    public List<Gamer> findAll() {
        return gamerRepository.findAll();
    }

    @Override
    public Gamer getObjectById(Long id) {
        Optional<Gamer> gamerOptional = gamerRepository.findById(id);
        return gamerOptional.get();
    }
}