package fr.EmiliePaniagua.poec.exam.repository;

import fr.EmiliePaniagua.poec.exam.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GameRepository extends JpaRepository<Game, Long>,SortByNameInterface<Game> {

    List<Game> findTop9ByOrderByPublishedAtDesc();

    List<Game> findTop6ByOrderByPublishedAtDesc();


    Game findBySlug(String slug);
}

