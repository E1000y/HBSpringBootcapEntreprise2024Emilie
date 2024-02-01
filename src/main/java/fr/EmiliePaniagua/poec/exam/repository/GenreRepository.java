package fr.EmiliePaniagua.poec.exam.repository;

import fr.EmiliePaniagua.poec.exam.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> , SortByNameInterface<Genre>{


}

