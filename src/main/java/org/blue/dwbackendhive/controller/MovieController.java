package org.blue.dwbackendhive.controller;
import org.blue.dwbackendhive.dto.NumDto;
import org.blue.dwbackendhive.dto.ScoreDto;
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


    // 获取某年某月电影的数量
    @GetMapping("/byTime/count/yearMonth")
    public NumDto getMovieCountByMonth(@RequestParam int year, @RequestParam int month) {
        return movieService.getMovieCountByMonth(year, month);
    }
    @GetMapping("/byTime/count/yearMonthDay")
    public NumDto getMovieCountByDateRange(@RequestParam String start,
                                        @RequestParam String end) {
        return movieService.getMovieCountByDateRange(start, end);
    }
    @GetMapping("/byTime/count/yearSeason")
    public NumDto getMovieCountByQuarter(@RequestParam int year, @RequestParam int season) {
        return movieService.getMovieCountByYearAndQuarter(year, season);
    }
    @GetMapping("/byMovieName/count/format")
    public NumDto getMovieVersionCountByTitle(@RequestParam String name) {
        return movieService.getMovieVersionCountByTitle(name);
    }
    @GetMapping("/director/dirmovie")
    public NumDto getMovieCountByDirector(@RequestParam String directorName) {
        return movieService.getMovieCountByDirector(directorName);
    }
    @GetMapping("/byActor/count/movie")
    public NumDto getMovieCountByActor(@RequestParam String actorName, @RequestParam String isStarring) {
        return movieService.getMovieCountByActor(actorName, isStarring);
    }
    @GetMapping("/byComment/score")
    public ScoreDto getMoviesByScore(@RequestParam double score) {
        return movieService.getMoviesByScore(score);
    }

}