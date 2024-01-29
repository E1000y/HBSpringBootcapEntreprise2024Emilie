package fr.EmiliePaniagua.poec.exam.controller;

import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Sort;

import java.security.Principal;

@Controller
@RequestMapping(UrlRoute.URL_REVIEW)
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping(path="/")
    public ModelAndView displayPagedReviews(
            ModelAndView mav,
            Principal principal,
            @PageableDefault(
                    size = 8,
                    sort = {"createdAt"},
                    direction = Sort.Direction.DESC
            ) Pageable pageable)
    {
        if(principal == null){
            mav.setViewName("redirect:/login");
            return mav;
        }

        mav.addObject("pagedReviews", reviewService.findAll(pageable));
        mav.setViewName("review/pagedReviews");
        return mav;
    }



}
