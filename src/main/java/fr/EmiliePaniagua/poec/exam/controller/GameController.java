package fr.EmiliePaniagua.poec.exam.controller;


import fr.EmiliePaniagua.poec.exam.DTO.ReviewDTO;
import fr.EmiliePaniagua.poec.exam.entity.Game;
import fr.EmiliePaniagua.poec.exam.entity.User;
import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.GameService;
import fr.EmiliePaniagua.poec.exam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(path = UrlRoute.URL_GAME , name = "AppGame")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    private final UserService userService;

    @GetMapping(path="/{id}", name ="displayGame")
    public ModelAndView displayGame(
            @PathVariable Long id,
            ModelAndView mav,
            Principal principal
    ) {
        Game game = gameService.findById(id);

        if (principal != null) {
            ReviewDTO dto = new ReviewDTO();
            dto.setGameId(game.getId());
            User user = userService.findByNickname(principal.getName());
            dto.setUserId(user.getId()); //pourquoi 1L?
            mav.addObject("reviewDto", dto);
        }

        mav.setViewName("game/displayGame");
        mav.addObject("game", game);
        return mav;

    }




}
