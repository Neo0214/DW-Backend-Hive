package org.blue.dwbackendhive.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

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

    @Select("SELECT COUNT(DISTINCT m.movie_id) " +
            "FROM movie m " +
            "WHERE m.grade >= #{score}")
    int getMoviesByScore(double score);@Mapper


        // 查询合作次数最多的一组演员
    @Select("""
    SELECT first_person_id, second_person_id, SUM(time_col) AS total_coop_time
    FROM AAcoop_time
    GROUP BY first_person_id, second_person_id
    ORDER BY total_coop_time DESC
    LIMIT 1
    """)
    Map<String, Object> getMostCooperativeActors();

    @Select("""
    SELECT first_person_id, second_person_id, SUM(time_col) AS total_coop_time
    FROM DAcoop_time
    GROUP BY first_person_id, second_person_id
    ORDER BY total_coop_time DESC
    LIMIT 1
    """)
    Map<String, Object> getMostCooperativeDA();
    @Select("SELECT COUNT(*) FROM movie WHERE type = #{typeName}")
    int countMoviesByType(@Param("typeName") String typeName);

    @Select("SELECT COUNT(DISTINCT m.movie_id) " +
            "FROM movie m " +
            "JOIN act a ON m.movie_id = a.movie_id " +
            "JOIN person p ON a.person_id = p.person_id " +
            "WHERE p.name = #{actorName} " )
    int countMoviesByActor(@Param("actorName") String actorName);

}