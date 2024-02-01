package fr.EmiliePaniagua.poec.exam.repository;

import fr.EmiliePaniagua.poec.exam.entity.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {


}

