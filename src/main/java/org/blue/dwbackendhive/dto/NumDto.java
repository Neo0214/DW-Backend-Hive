package org.blue.dwbackendhive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumDto {
    private double time;  // 查询时间
    private int num;
}
