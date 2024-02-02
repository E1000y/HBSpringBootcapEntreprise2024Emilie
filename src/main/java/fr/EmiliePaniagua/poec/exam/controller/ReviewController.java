package fr.EmiliePaniagua.poec.exam.controller;

import fr.EmiliePaniagua.poec.exam.routes.UrlRoute;
import fr.EmiliePaniagua.poec.exam.service.ReviewService;
import fr.EmiliePaniagua.poec.exam.utils.ExcelReviewService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Sort;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ExcelReviewService excelService;

    @GetMapping(path=UrlRoute.URL_REVIEW)
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

    @GetMapping(UrlRoute.URL_EXPORT)
    public void downloadExcel(HttpServletResponse response) {
        try {
            File file = excelService.writeExcel();
            ByteArrayInputStream excelToByte = new ByteArrayInputStream(
                    Files.readAllBytes(Paths.get(file.getAbsolutePath()))
            );
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
            IOUtils.copy(excelToByte, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
