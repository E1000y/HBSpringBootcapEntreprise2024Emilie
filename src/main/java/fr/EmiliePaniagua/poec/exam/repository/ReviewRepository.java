package fr.EmiliePaniagua.poec.exam.repository;

import fr.EmiliePaniagua.poec.exam.entity.Gamer;
import fr.EmiliePaniagua.poec.exam.entity.Review;
import fr.EmiliePaniagua.poec.exam.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    public List<Review> findTop5ByOrderByCreatedAtDesc();

    public Page<Review> findAllByGameId(Long id, Pageable pageable);

    public List<Review> findTop5ByModeratorIsNotNullOrGamer(User user);


    Page<Review> findAllByGamerNickname(String nickname, Pageable pageable);

    Page<Review> findByModeratorIsNotNullAndGamerNickname(String nickname, Pageable pageable);
}

