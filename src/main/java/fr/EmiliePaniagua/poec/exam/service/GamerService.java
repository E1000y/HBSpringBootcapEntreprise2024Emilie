package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.DTO.RegisterDTO;
import fr.EmiliePaniagua.poec.exam.entity.Gamer;
import fr.EmiliePaniagua.poec.exam.repository.GamerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GamerService implements DAOServiceInterface<Gamer> {

    private GamerRepository gamerRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Gamer> findAll() {
        return gamerRepository.findAll();
    }

    @Override
    public Gamer findById(Long id) {
        Optional<Gamer> gamerOptional = gamerRepository.findById(id);
        return gamerOptional.get();
    }

    @Override
    public Object findAllSorted() {
        return gamerRepository.findAll();
    }

    public Gamer persist(RegisterDTO registerDTO) {
        Gamer gamer = new Gamer();
        gamer.setNickname(registerDTO.getNickname());
        gamer.setEmail(registerDTO.getEmail());
        gamer.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        gamer.setBirthAt(LocalDate.parse(registerDTO.getBirthAt(), formatter));
        return gamerRepository.saveAndFlush(gamer);
    }
}