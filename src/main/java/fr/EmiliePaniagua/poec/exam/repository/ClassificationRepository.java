package fr.EmiliePaniagua.poec.exam.repository;

import fr.EmiliePaniagua.poec.exam.entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long>, SortByNameInterface<Classification> {


}

