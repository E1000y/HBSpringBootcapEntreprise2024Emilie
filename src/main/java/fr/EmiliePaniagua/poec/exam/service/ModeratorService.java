package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.Moderator;
import fr.EmiliePaniagua.poec.exam.repository.ModeratorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeratorService implements DAOServiceInterface<Moderator>{

    private ModeratorRepository moderatorRepository ;
    @Override
    public List<Moderator> findAll() {
        return moderatorRepository.findAll();
    }

    @Override
    public Moderator getObjectById(Long id) {
        Optional<Moderator> moderatorOptional = moderatorRepository.findById(id);
        return moderatorOptional.get();
    }
}