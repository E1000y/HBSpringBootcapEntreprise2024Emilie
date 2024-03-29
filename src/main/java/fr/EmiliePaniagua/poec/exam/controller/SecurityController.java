package fr.EmiliePaniagua.poec.exam.controller;

import fr.EmiliePaniagua.poec.exam.DTO.RegisterDTO;
import fr.EmiliePaniagua.poec.exam.entity.Gamer;

import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.GamerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
@AllArgsConstructor
public class SecurityController {

    private final GamerService gamerService;

    @GetMapping(UrlRoute.URL_LOGIN)
    public ModelAndView login(ModelAndView mav, Principal principal, String error) {
        if (principal != null) {
            System.out.println("Un type est connecté, on renvoie vers la home");
            mav.setViewName("redirect:/");
            return mav;
        }
        System.out.println("Personne n'est co on affiche login");
        if (error != null) {
            mav.addObject("error", "Identifiants sont incorrects !");
        }
        mav.setViewName("security/login");
        return mav;
    }

    //-------tests sur le register

//@get pour accéder au formulaire
@GetMapping(UrlRoute.URL_REGISTER)
    public ModelAndView register(ModelAndView mav){
        mav.setViewName("security/register");
        mav.addObject("registerDTO", new RegisterDTO());
        return mav;
}

    //post pour soumettre le formulaire
    @PostMapping(UrlRoute.URL_REGISTER)
    public ModelAndView register(
            @ModelAttribute("registerDTO") @Valid RegisterDTO registerDTO,
            BindingResult result,
            ModelAndView mav
    ) {
        if (result.hasErrors()) {
            mav.setViewName("security/register");
            mav.addObject("registerDTO", registerDTO);
            return mav;
        }

        gamerService.persist(registerDTO);
        mav.setViewName("redirect:/login");
        return mav;
    }




}
