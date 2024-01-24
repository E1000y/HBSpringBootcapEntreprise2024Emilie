package fr.EmiliePaniagua.poec.exam.controller;

import fr.EmiliePaniagua.poec.exam.service.ReviewService;
import fr.EmiliePaniagua.poec.exam.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@AllArgsConstructor
public class IndexController {

    //private UserService userService;
    private ReviewService reviewService;
    private GameService gameService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("index");
        mav.addObject("games", gameService.findTop9ByPublishedAtDesc());
        mav.addObject("reviews", reviewService.findTop5ByCreatedAtDesc());

        return mav;
    }


}