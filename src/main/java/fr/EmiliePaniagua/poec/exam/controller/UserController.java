package fr.EmiliePaniagua.poec.exam.controller;


import fr.EmiliePaniagua.poec.exam.entity.User;
import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.ReviewService;
import fr.EmiliePaniagua.poec.exam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    private ReviewService reviewService;

    @GetMapping(UrlRoute.URL_USER_SHOW)
    public ModelAndView show(
        ModelAndView mav,
        @PathVariable String uuid,
        @PageableDefault(
                size = 6, // nb Element par page
                sort = { "createdAt" }, // order by
                direction = Sort.Direction.DESC
        ) Pageable pageable,
        Principal principal

    ) {
        mav.setViewName("user/show");
        User user = userService.findByUuid(uuid);
        mav.addObject("user", user);
        mav.addObject("pagedReviews", reviewService.findReviewsForProfile(user, principal, pageable));
        return mav;
    }

}