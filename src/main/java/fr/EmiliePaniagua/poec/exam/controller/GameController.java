package fr.EmiliePaniagua.poec.exam.controller;


import fr.EmiliePaniagua.poec.exam.DTO.ReviewDTO;
import fr.EmiliePaniagua.poec.exam.entity.Game;
import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = UrlRoute.URL_GAME , name = "AppGame")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;
    @GetMapping(path="/{id}", name ="displayGame")
    public ModelAndView displayGame(@PathVariable Long id, ModelAndView mav){

        Game game = gameService.findById(id);

        ReviewDTO dto = new ReviewDTO();

        mav.setViewName("game/displayGame");
        mav.addObject("game", game);
        return mav;

    }




}
