package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.User;
import fr.EmiliePaniagua.poec.exam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User>{
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll()
    }

    @Override
    public User getObjectById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }
}