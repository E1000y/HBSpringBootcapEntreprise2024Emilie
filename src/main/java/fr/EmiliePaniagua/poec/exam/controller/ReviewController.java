package fr.EmiliePaniagua.poec.exam.controller;


import fr.EmiliePaniagua.poec.exam.DTO.ReviewDTO;
import fr.EmiliePaniagua.poec.exam.service.GameService;
import fr.EmiliePaniagua.poec.exam.service.ReviewService;
import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping( name ="AppReview")
public class ReviewController {
    private ReviewService reviewService;
    private GameService gameService;

    @PostMapping(path= UrlRoute.URL_REVIEW_CREATE+"game/{id}", name = "create")
    public ModelAndView createReview(
            @PathVariable Long id,
            @ModelAttribute("reviewDto") @Valid ReviewDTO reviewDto,
            BindingResult result,//c'est quoi? rep dono : contient les erreurs du formulaire
            ModelAndView mav
    ){
        if(result.hasErrors()){
            mav.setViewName("game/displayGame");
            mav.addObject("game", gameService.findById(id));
            return mav;
        }
        reviewService.persist(reviewDto);

        mav.setViewName("redirect/game/"+id);
        return mav;
    }
}
