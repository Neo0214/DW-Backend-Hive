package org.blue.dwbackendhive.service;
import org.blue.dwbackendhive.dto.NumDto;
import org.blue.dwbackendhive.dto.ScoreDto;
import org.blue.dwbackendhive.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieMapper movieMapper;

    @Autowired
    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }




    // 获取某年某月电影的数量
    public NumDto getMovieCountByMonth(int year, int month) {
        long startTime = System.currentTimeMillis();
        int count =movieMapper.countMoviesByMonth(year, month);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return new NumDto(elapsedTime, count);
    }
    public NumDto getMovieCountByDateRange(String startDate, String endDate) {
        // 调用 Mapper 查询数据
        // 提取开始日期的年、月、日
        String[] startParts = startDate.split("-");
        int startYear = Integer.parseInt(startParts[0]);
        int startMonth = Integer.parseInt(startParts[1]);
        int startDay = Integer.parseInt(startParts[2]);

        // 提取结束日期的年、月、日
        String[] endParts = endDate.split("-");
        int endYear = Integer.parseInt(endParts[0]);
        int endMonth = Integer.parseInt(endParts[1]);
        int endDay = Integer.parseInt(endParts[2]);
        long startTime = System.currentTimeMillis();
        int count =movieMapper.getMovieCountByDateRange(startYear, startMonth,startDay, endYear, endMonth, endDay);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return new NumDto(elapsedTime, count);
    }
    public NumDto getMovieCountByYearAndQuarter(int year, int quarter) {
        // 根据季度选择对应的月份范围
        long startTime = System.currentTimeMillis();
        int startMonth = 0;
        int endMonth = 0;

        switch (quarter) {
            case 1: // 第一季度：1月到3月
                startMonth = 1;
                endMonth = 3;
                break;
            case 2: // 第二季度：4月到6月
                startMonth = 4;
                endMonth = 6;
                break;
            case 3: // 第三季度：7月到9月
                startMonth = 7;
                endMonth = 9;
                break;
            case 4: // 第四季度：10月到12月
                startMonth = 10;
                endMonth = 12;
                break;
            default:
                throw new IllegalArgumentException("Invalid quarter: " + quarter);
        }
        int count=movieMapper.getMovieCountByYearAndQuarter(year, startMonth, endMonth);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        // 调用 Mapper 查询数据
        return new NumDto(elapsedTime, count);
    }
    public NumDto getMovieVersionCountByTitle(String title) {
        // 根据电影名称获取 movie_id
        long startTime = System.currentTimeMillis();
        Long movieId = movieMapper.getMovieIdByTitle(title);

        // 如果找不到电影ID，返回 0 或者抛出异常
        if (movieId == null) {
            throw new RuntimeException("Movie not found");
        }
        int count=movieMapper.getMovieVersionCount(movieId);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        // 查询并返回该电影的版本数
        return new NumDto(elapsedTime, count);
    }
    public NumDto getMovieCountByDirector(String directorName) {

        long startTime = System.currentTimeMillis();
        int count= movieMapper.getMovieCountByDirector(directorName);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return new NumDto(elapsedTime, count);
    }

    public NumDto getMovieCountByActor(String actorName,String isStarring) {
        long startTime = System.currentTimeMillis();
        int count= movieMapper. getMovieCountByActorAndLeadStatus(actorName,isStarring);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return new NumDto(elapsedTime, count);
    }
    public ScoreDto getMoviesByScore(double score) {
        long startTime = System.currentTimeMillis();

        // 获取电影列表
        List<ScoreDto.Name> movies = movieMapper.getMoviesByScore(score);

        long endTime = System.currentTimeMillis();

        // 计算查询所用的时间（秒）
        long timeTaken = endTime - startTime;

        // 构造返回的响应
        return new ScoreDto(timeTaken,movies.size(), movies);
    }
}
