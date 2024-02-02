package fr.EmiliePaniagua.poec.exam.controller;


import fr.EmiliePaniagua.poec.exam.DTO.GameDTO;
import fr.EmiliePaniagua.poec.exam.DTO.ReviewDTO;
import fr.EmiliePaniagua.poec.exam.entity.Game;
import fr.EmiliePaniagua.poec.exam.entity.User;
import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.*;
import fr.EmiliePaniagua.poec.exam.utils.FileUploadService;
import fr.EmiliePaniagua.poec.exam.utils.FlashMessage;
import fr.EmiliePaniagua.poec.exam.utils.FlashMessageBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
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
    private FileUploadService fileUploadService;
    private FlashMessageBuilder flashMessageBuilder;



    @GetMapping(UrlRoute.URL_GAME)
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

    @GetMapping(UrlRoute.URL_GAME_SLUG)
    public ModelAndView show(
            @PathVariable String slug,
            ModelAndView mav,
            Principal principal,
            @ModelAttribute("flashMessage") FlashMessage flashMessage,
            @PageableDefault(
                    size = 6, // nb Element par page
                    sort = { "createdAt" }, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        mav.setViewName("game/displayGame");
        if (principal != null) {
            mav.addObject("reviewDto", new ReviewDTO());
        }
        Game game = gameService.findBySlug(slug);
        mav.addObject("flashMessage", flashMessage);
        mav.addObject("game", game);
        mav.addObject("pagedReviews", reviewService.findAllByGame(game, pageable));
        return mav;
    }

    @PostMapping(path = UrlRoute.URL_GAME_SLUG)
    public ModelAndView createReview(
            @PathVariable String slug,
            @ModelAttribute("reviewDto") @Valid ReviewDTO reviewDto,
            BindingResult result,//c'est quoi? rep dono : contient les erreurs du formulaire
            ModelAndView mav
    ){
        System.out.println("error");
        if(result.hasErrors()){
            mav.setViewName("game/displayGame");
            mav.addObject("game", gameService.findBySlug(slug));
            return mav;
        }
        reviewService.persist(reviewDto);

        mav.setViewName("redirect:" + UrlRoute.URL_GAME + "/" + slug);
        return mav;
    }

    @GetMapping(UrlRoute.URL_GAME_UPLOAD_IMAGE_PATH)
    public ModelAndView uploadImage(
            ModelAndView mav,
            @PathVariable String slug
    ) {
        mav.setViewName("game/upload-image");
        return mav;
    }

    @PostMapping(UrlRoute.URL_GAME_UPLOAD_IMAGE_PATH)
    public ModelAndView uploadImage(
            ModelAndView mav,
            @RequestParam("file") MultipartFile file,
            @PathVariable String slug,
            RedirectAttributes redirectAttributes
    ) {
        String fileName = fileUploadService.uploadFile(file, "game", slug);
        if (fileName.contains("erreur")) {
            redirectAttributes.addFlashAttribute(
                    "flashMessage",
                    flashMessageBuilder.createDangerFlashMessage(fileName)
            );
            mav.setViewName("game/upload-image");
            return mav;
        }
        gameService.saveImageToGame(fileName, slug);
        redirectAttributes.addFlashAttribute(
                "flashMessage",
                flashMessageBuilder.createSuccessFlashMessage("Image téléversée avec succès !")
        );
        mav.setViewName("redirect:" + UrlRoute.URL_GAME + "/" + slug);
        return mav;
    }

    @GetMapping(path = UrlRoute.URL_GAME_NEW)
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

    @PostMapping(path = UrlRoute.URL_GAME_NEW)
    public ModelAndView saveNewGame(
            @ModelAttribute("gameDTO") @Valid GameDTO gameDTO,
            BindingResult errors,
            ModelAndView mav,
            RedirectAttributes redirectAttributes,
            Principal principal
    ){
        if(errors.hasErrors()){
            mav.setViewName("game/addGame");
            return mav;
        }
        redirectAttributes.addFlashAttribute(
                "flashMessage",
                flashMessageBuilder.createSuccessFlashMessage("Jeu créé avec succès !")
        );
        mav.setViewName("redirect:" + UrlRoute.URL_GAME + "/" + gameService.create(gameDTO, principal.getName()).getSlug());
        return mav;
    }
}


