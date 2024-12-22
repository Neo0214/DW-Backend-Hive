package org.blue.dwbackendhive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ScoreDto {
    private double time;  // 查询时间
    private int num;      // 符合评分条件的电影数量
    private List<Name> data;  // 符合条件的电影列表
    @Data
    @AllArgsConstructor
    public static class Name {
        private String movie;  // 评分
    }
}