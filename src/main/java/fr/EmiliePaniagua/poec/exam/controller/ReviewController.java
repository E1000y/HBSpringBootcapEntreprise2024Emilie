package fr.EmiliePaniagua.poec.exam.controller;

import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Sort;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping()
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping(path=UrlRoute.URL_REVIEW+"/")
    public ModelAndView displayPagedReviews(
            ModelAndView mav,
            Principal principal,
            @PageableDefault(
                    size = 6,
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

    @GetMapping(value = UrlRoute.URL_REVIEW_MODERATE+"/{id}/{moderate}")
    public ModelAndView moderate(
            @PathVariable Long id,
            @PathVariable Long moderate,
            ModelAndView mav,
            RedirectAttributes redirectAttributes,
            Principal principal
    ) {
        reviewService.moderateReview(principal.getName(), id, moderate);
        mav.setViewName("redirect:"+UrlRoute.URL_REVIEW+"/");
        return mav;
    }



}
