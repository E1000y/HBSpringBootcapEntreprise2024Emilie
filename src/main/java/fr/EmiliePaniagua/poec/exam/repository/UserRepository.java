package fr.EmiliePaniagua.poec.exam.repository;

import fr.EmiliePaniagua.poec.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNickname(String username);


}

