package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.DTO.GameDTO;
import fr.EmiliePaniagua.poec.exam.entity.Game;
import fr.EmiliePaniagua.poec.exam.entity.Moderator;
import fr.EmiliePaniagua.poec.exam.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService implements DAOServiceInterface<Game> {

    private GameRepository gameRepository;

    private UserService userService;
    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(Long id) {
        Optional<Game> gameOptional = gameRepository.findById(id);
        return gameOptional.get();

    }

    @Override
    public Object findAllSorted() {
        return gameRepository.findAllByOrderByNameAsc();
    }


    public List<Game> findTop6ByPublishedAtDesc() {
        return gameRepository.findTop6ByOrderByPublishedAtDesc();
    }


    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }


    public Game persist(GameDTO gameDTO, String nickname){
        Game game = new Game();
        game.setName(gameDTO.getName());
        game.setDescription(gameDTO.getDescription());
        game.setPublishedAt(LocalDate.parse(gameDTO.getPublishedAt()));
        game.setGenre(gameDTO.getGenre());
        game.setBusinessModel(gameDTO.getBusinessModel());
        game.setPublisher(gameDTO.getPublisher());
        game.setClassification(gameDTO.getClassification());
        game.setPlatforms(gameDTO.getPlatforms());
      game.setModerator((Moderator) userService.findByNickname(nickname));
        game.setImage("https://static.vecteezy.com/system/resources/previews/005/337/799/original/icon-image-not-found-free-vector.jpg");
        return gameRepository.saveAndFlush(game);

        }

}

