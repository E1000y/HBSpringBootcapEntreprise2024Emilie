package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.Genre;
import fr.EmiliePaniagua.poec.exam.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreService implements DAOServiceInterface {
    private GenreRepository genreRepository;


    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll()
    }

    @Override
    public Genre getObjectById(Long id) {

        Optional<Genre> optionalGenre = genreRepository.findById(id);

        return optionalGenre.get();
    }
}