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
    private int timeCol;
    private List<Long> movieId;
}