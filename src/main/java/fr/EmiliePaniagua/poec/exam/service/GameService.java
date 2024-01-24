package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.Game;
import fr.EmiliePaniagua.poec.exam.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService implements DAOServiceInterface<Game> {

    private GameRepository gameRepository;
    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(Long id) {
        Optional<Game> gameOptional = gameRepository.findById(id);
        return gameOptional.get();

    }

    public List<Game> findTop9ByPublishedAtDesc(){
        return gameRepository.findTop9ByOrderByPublishedAtDesc();
    }
}