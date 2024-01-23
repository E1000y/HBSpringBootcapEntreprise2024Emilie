package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.Publisher;
import fr.EmiliePaniagua.poec.exam.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublisherService implements DAOServiceInterface<Publisher> {

    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(Long id) {
        Optional<Publisher> platformOptional = publisherRepository.findById(id);
        return platformOptional.get();

    }
}