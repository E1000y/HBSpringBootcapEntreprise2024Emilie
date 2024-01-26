package fr.EmiliePaniagua.poec.exam.controller;

import fr.EmiliePaniagua.poec.exam.service.GameService;
import fr.EmiliePaniagua.poec.exam.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {

    private ReviewService reviewService;

    private GameService gameService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav, Principal principal) {
        if (principal == null) {
            System.out.println("Personne n'est co on renvoie vers login");
            mav.setViewName("redirect:/login");
            return mav;
        }
        System.out.println("Un type est connecté, on affiche la home");
        mav.setViewName("index2");
        mav.addObject("games", gameService.findTop6ByPublishedAtDesc());
        mav.addObject("reviews", reviewService.findTop5ByCreatedAtDesc());
        return mav;
    }



}
