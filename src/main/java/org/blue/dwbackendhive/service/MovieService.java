package org.blue.dwbackendhive.service;
import org.blue.dwbackendhive.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieMapper movieMapper;

    @Autowired
    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    // 获取某年所有电影的数量
    public int getMovieCountByYear(int year) {
        return movieMapper.countMoviesByYear(year);
    }

    // 获取某年某月电影的数量
    public int getMovieCountByMonth(int year, int month) {
        return movieMapper.countMoviesByMonth(year, month);
    }
}
