//package fr.EmiliePaniagua.poec.exam.controller;
//
//import fr.EmiliePaniagua.poec.exam.service.GenreService;
//import fr.EmiliePaniagua.poec.exam.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@AllArgsConstructor
//public class HelloWorldController {
//
//    private UserService userService;
//    private GenreService genreService;
//
//    @GetMapping("/HelloWorld")
//    public ModelAndView helloWorld(ModelAndView mav){
//        mav.setViewName("HelloWorld");
//     mav.addObject("users", userService.findAll());
//     mav.addObject("genre", genreService.findAll());
//        return mav;
//    }
//
//}
