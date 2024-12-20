package org.blue.dwbackendhive.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MovieMapper {

    // 查询某年所有电影的数量
    @Select("SELECT COUNT(*) FROM movie WHERE year = #{year}")
    int countMoviesByYear(int year);

    // 查询某年某月电影的数量
    @Select("SELECT COUNT(*) FROM movie WHERE year = #{year} AND month = #{month}")
    int countMoviesByMonth(int year, int month);
}