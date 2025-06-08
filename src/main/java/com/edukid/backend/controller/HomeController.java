package com.edukid.backend.controller;

import com.edukid.backend.model.News;
import com.edukid.backend.model.Teacher;
import com.edukid.backend.model.Review;
import com.edukid.backend.service.BannerService;
import com.edukid.backend.service.NewsService;
import com.edukid.backend.service.ReviewService;
import com.edukid.backend.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final BannerService bannerService;
    private final TeacherService teacherService;
    private final ReviewService reviewService;
    private final NewsService newsService;

    public HomeController(BannerService bannerService, TeacherService teacherService, ReviewService reviewService, NewsService newsService) {
        this.bannerService = bannerService;
        this.teacherService = teacherService;
        this.reviewService = reviewService;
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String home(Model model) throws Exception {
        // Получаем текст баннера (на русском)
        String bannerText = bannerService.getBanner().getRu();
        model.addAttribute("bannerText", bannerText);

        // Получаем список педагогов
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);

        // Получаем отзывы родителей
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);

        List<News> newsList = newsService.getAllNews();
        model.addAttribute("newsList", newsList);

        return "index";
    }
}