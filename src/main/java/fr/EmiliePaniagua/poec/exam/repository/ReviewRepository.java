package fr.EmiliePaniagua.poec.exam.repository;

import fr.EmiliePaniagua.poec.exam.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    public List<Review> findTop5ByOrderByCreatedAtDesc();

    public Page<Review> findAllByGameId(Long id, Pageable pageable);
}

