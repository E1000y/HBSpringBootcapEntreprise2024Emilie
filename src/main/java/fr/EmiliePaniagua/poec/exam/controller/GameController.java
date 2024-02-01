package fr.EmiliePaniagua.poec.exam.controller;


import fr.EmiliePaniagua.poec.exam.DTO.GameDTO;
import fr.EmiliePaniagua.poec.exam.DTO.ReviewDTO;
import fr.EmiliePaniagua.poec.exam.entity.Game;
import fr.EmiliePaniagua.poec.exam.entity.User;
import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.*;
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
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping(UrlRoute.URL_GAME)
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    private final UserService userService;

    private final ReviewService reviewService;
    private final GenreService genreService;
    private final ClassificationService classificationService;
    private final BusinessModelService businessModelService;
    private final PublisherService publisherService;
    private final PlatformService platformService;



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
    @GetMapping(path="/new")

    public ModelAndView createGame(
            ModelAndView mav
    ){
        mav.addObject("gameDto", new GameDTO());
        mav.addObject("genres", genreService.findAllSorted());
        mav.addObject("classifications", classificationService.findAllSorted());
        mav.addObject("businessModels", businessModelService.findAllSorted());
        mav.addObject("publishers", publisherService.findAllSorted());
        mav.addObject("platforms", platformService.findAllSorted());

        mav.addObject("gameDTO", new GameDTO());
        mav.setViewName("game/addGame");
        return mav;

    }

    @PostMapping(path="/new")

    public ModelAndView saveNewGame(
            @ModelAttribute("gameDTO") @Valid GameDTO gameDTO,
            BindingResult errors,
            ModelAndView mav,
            Principal principal
    ){
        String nickname = principal.getName();

        if(errors.hasErrors()){
            mav.setViewName("game/addGame");
            return mav;
        }
        mav.setViewName("game/displayGame");
        gameService.persist(gameDTO, nickname);
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
