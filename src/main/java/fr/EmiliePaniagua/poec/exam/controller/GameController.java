package fr.EmiliePaniagua.poec.exam.controller;


import fr.EmiliePaniagua.poec.exam.DTO.ReviewDTO;
import fr.EmiliePaniagua.poec.exam.entity.Game;
import fr.EmiliePaniagua.poec.exam.entity.User;
import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.GameService;
import fr.EmiliePaniagua.poec.exam.service.ReviewService;
import fr.EmiliePaniagua.poec.exam.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(UrlRoute.URL_GAME)
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    private final UserService userService;

    private final ReviewService reviewService;

    @GetMapping(path="/")
    public ModelAndView displayPagedGames(
            ModelAndView mav,
            Principal principal,
            @PageableDefault(
                    size = 8,
                    sort = {"name"},
                    direction = Sort.Direction.ASC
            )Pageable pageable
    ){
        if(principal == null){
            mav.setViewName("redirect:/login");
            return mav;
        }

        mav.addObject("pagedGames", gameService.findAll(pageable));
        mav.setViewName("game/pagedGames");
        return mav;
    }



    @GetMapping(path="/{id}", name ="displayGame")
    public ModelAndView displayGame(
            @PathVariable Long id,
            ModelAndView mav,
            Principal principal,
            @PageableDefault(
                    size = 6,
                    sort = {"createdAt"},
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        Game game = gameService.findById(id);

        if (principal != null) {
            ReviewDTO dto = new ReviewDTO();
            dto.setGameId(game.getId());
            User user = userService.findByNickname(principal.getName());
            dto.setUserId(user.getId());
            mav.addObject("reviewDto", dto);
        }

        mav.setViewName("game/displayGame");
        mav.addObject("pagedReviews", reviewService.findAllByGameId(id,pageable));
        mav.addObject("game", game);
        return mav;

    }

    @PostMapping(path="/{id}")
    public ModelAndView createReview(
            @PathVariable Long id,
            @ModelAttribute("reviewDto") @Valid ReviewDTO reviewDto,
            BindingResult result,//c'est quoi? rep dono : contient les erreurs du formulaire
            ModelAndView mav
    ){
        System.out.println("error");
        if(result.hasErrors()){
            mav.setViewName("game/displayGame");
            mav.addObject("game", gameService.findById(id));
            return mav;
        }
        reviewService.persist(reviewDto);

        mav.setViewName("redirect:/game/"+id);
        return mav;
    }

//    @GetMapping(path="/{id}")
//    public ModelAndView displayPagedReviews(
//            ModelAndView mav,
//            Principal principal,
//            @PageableDefault(
//                    size = 6,
//                    sort = {"createdAt"},
//                    direction = Sort.Direction.DESC
//            ) Pageable pageable)
//    {
//        if(principal == null){
//            mav.setViewName("redirect:/login");
//            return mav;
//        }
//
//        mav.addObject("pagedReviews", reviewService.findAllByGameId(id,pageable));
//        mav.setViewName("game/displayGame");
//        return mav;
//    }

}
