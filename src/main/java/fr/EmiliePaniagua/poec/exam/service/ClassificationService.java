package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.Classification;
import fr.EmiliePaniagua.poec.exam.repository.ClassificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClassificationService implements DAOServiceInterface<Classification> {

    private ClassificationRepository classificationRepository;


    @Override
    public List<Classification> findAll() {
        return classificationRepository.findAll();
    }

    @Override
    public Classification findById(Long id) {
        Optional<Classification> optionalClassification = classificationRepository.findById(id);
        return optionalClassification.get();
    }
}