package fr.EmiliePaniagua.poec.exam.service;

import fr.EmiliePaniagua.poec.exam.DTO.ReviewDTO;
import fr.EmiliePaniagua.poec.exam.entity.*;
import fr.EmiliePaniagua.poec.exam.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService implements DAOServiceInterface<Review> {

    private ReviewRepository reviewRepository;
    private GameService gameService;
    private GamerService gamerService;
    private UserService userService;
    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Review not found"));

    }

    @Override
    public Object findAllSorted() {
        return reviewRepository.findAll();
    }

    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public Page<Review> findAllByGameId(Long id,Pageable pageable){return reviewRepository.findAllByGameId(id, pageable);}

//    public List<Review> findTop5ByCreatedAtDesc(){
//
//    }

    public List<Review> findTop5ModeratorIsNotNullOrGamer(User user){

        if(user instanceof Moderator){
            return reviewRepository.findTop5ByOrderByCreatedAtDesc();
        }
        else{
            return reviewRepository.findTop5ByModeratorIsNotNullOrGamer(user);
        }

    }

    public Review persist(ReviewDTO reviewDTO){
        Review review = new Review();
        review.setGame(gameService.findById(reviewDTO.getGameId()));
        review.setDescription(reviewDTO.getDescription());
        review.setGamer(gamerService.findById(reviewDTO.getUserId()));
        review.setRating(reviewDTO.getRating());
        return reviewRepository.saveAndFlush(review);

    }

    public Page<Review> findReviewsForProfile(
            User user,
            Principal principal,
            Pageable pageable
    ) {
        if (user.getNickname().equals(principal.getName())) {
            return reviewRepository.findAllByGamerNickname(user.getNickname(), pageable);
        }
        return reviewRepository.findByModeratorIsNotNullAndGamerNickname(user.getNickname(), pageable);
    }


    public void moderateReview(String nickname, Long id, Long status) {
        Review review = findById(id);
        boolean isModerate = true;
        if (status == 1L) {
            review.setModerator((Moderator) userService.findByNickname(nickname));
            review.setModeratedAt(LocalDateTime.now());
        } else {
            reviewRepository.delete(review);
            isModerate = false;
        }
        reviewRepository.flush();



}

    public Object findAllByGame(Game game, Pageable pageable) {
        return reviewRepository.findAllByGame(game, pageable);
    }

    public Object findAllByGameSlug(String slug, Pageable pageable) {
        return reviewRepository.findAllByGameSlug(slug, pageable);
    }
}