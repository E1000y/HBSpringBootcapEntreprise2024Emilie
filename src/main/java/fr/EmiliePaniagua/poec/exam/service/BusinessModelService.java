package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.BusinessModel;
import fr.EmiliePaniagua.poec.exam.repository.BusinessModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BusinessModelService implements DAOServiceInterface<BusinessModel>{

    private BusinessModelRepository businessModelRepository;

    public List<BusinessModel> findAll(){
        return businessModelRepository.findAll();
    }

    @Override
    public BusinessModel findById(Long id) {
        Optional<BusinessModel> optionalbm =  businessModelRepository.findById(id);

        return optionalbm.get();
    }

}