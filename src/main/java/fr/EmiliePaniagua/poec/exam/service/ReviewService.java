package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.entity.Review;
import fr.EmiliePaniagua.poec.exam.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService implements DAOServiceInterface<Review> {

    private ReviewRepository reviewRepository;
    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Review not found"));

    }

    public List<Review> findTop5ByCreatedAtDesc(){
        return reviewRepository.findTop5ByOrderByCreatedAtDesc();



    }
}