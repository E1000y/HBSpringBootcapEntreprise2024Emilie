package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.Moderator;
import fr.EmiliePaniagua.poec.exam.entity.User;
import fr.EmiliePaniagua.poec.exam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User>, UserDetailsService {

    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNickname(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getNickname(),
                user.getPassword(),
                userGrantedAuthority(user)
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(User user) {
        if (user instanceof Moderator) {
            return List.of(new SimpleGrantedAuthority("ROLE_MODERATOR"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_GAMER"));
    }
}