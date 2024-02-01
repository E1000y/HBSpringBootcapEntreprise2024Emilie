package fr.EmiliePaniagua.poec.exam.repository;

import fr.EmiliePaniagua.poec.exam.entity.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GamerRepository extends JpaRepository<Gamer, Long> {


}

