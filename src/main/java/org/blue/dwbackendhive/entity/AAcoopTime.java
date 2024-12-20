package org.blue.dwbackendhive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class AAcoopTime {
    private long firstPersonId;
    private long secondPersonId;
    private String type;
    private int time;
    private List<Long> movieId;
}