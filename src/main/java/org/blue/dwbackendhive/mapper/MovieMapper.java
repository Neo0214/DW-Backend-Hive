package org.blue.dwbackendhive.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.blue.dwbackendhive.dto.ScoreDto;

import java.util.List;

@Mapper
public interface MovieMapper {



    // 查询某年某月电影的数量
    @Select("SELECT COUNT(*) FROM movie WHERE year = #{year} AND month = #{month}")
    int countMoviesByMonth(int year, int month);

    @Select("""
        SELECT COUNT(*) 
        FROM movie 
        WHERE (year > #{startYear} 
               OR (year = #{startYear} AND month > #{startMonth}) 
               OR (year = #{startYear} AND month = #{startMonth} AND day >= #{startDay})) 
          AND (year < #{endYear} 
               OR (year = #{endYear} AND month < #{endMonth}) 
               OR (year = #{endYear} AND month = #{endMonth} AND day <= #{endDay}))
    """)
    int getMovieCountByDateRange(@Param("startYear") int startYear,
                                 @Param("startMonth") int startMonth,
                                 @Param("startDay") int startDay,
                                 @Param("endYear") int endYear,
                                 @Param("endMonth") int endMonth,
                                 @Param("endDay") int endDay);
    @Select("SELECT COUNT(*) FROM movie WHERE year = #{year} AND month BETWEEN #{startMonth} AND #{endMonth}")
    int getMovieCountByYearAndQuarter(@Param("year") int year,
                                      @Param("startMonth") int startMonth,
                                      @Param("endMonth") int endMonth);
    @Select("SELECT movie_id FROM movie WHERE title = #{title} LIMIT 1")
    Long getMovieIdByTitle(String title);

    @Select("SELECT COUNT(DISTINCT Format) FROM product WHERE movie_id = #{movieId}")
    int getMovieVersionCount(Long movieId);
    @Select("SELECT COUNT(DISTINCT m.movie_id) " +
            "FROM movie m " +
            "JOIN direct d ON m.movie_id = d.movie_id " +
            "JOIN person p ON d.person_id = p.person_id " +
            "WHERE p.name = #{directorName}")
    int getMovieCountByDirector(String directorName);

    @Select("SELECT COUNT(DISTINCT m.movie_id) " +
            "FROM movie m " +
            "JOIN act a ON m.movie_id = a.movie_id " +
            "JOIN person p ON a.person_id = p.person_id " +
            "WHERE p.name = #{actorName} " +
            "AND a.id_starring = #{isLead}")
    int getMovieCountByActorAndLeadStatus(String actorName, String isLead);

    @Select("SELECT m.title " +
            "FROM movie m " +
            "WHERE m.grade >= #{score}")
    List<ScoreDto.Name> getMoviesByScore(double score);
}