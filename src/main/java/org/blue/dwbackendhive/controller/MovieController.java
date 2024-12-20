package org.blue.dwbackendhive.controller;
import org.blue.dwbackendhive.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // 获取某年所有电影的数量
    @GetMapping("/movie-count-by-year")
    public int getMovieCountByYear(@RequestParam int year) {
        return movieService.getMovieCountByYear(year);
    }

    // 获取某年某月电影的数量
    @GetMapping("/movie-count-by-month")
    public int getMovieCountByMonth(@RequestParam int year, @RequestParam int month) {
        return movieService.getMovieCountByMonth(year, month);
    }
}