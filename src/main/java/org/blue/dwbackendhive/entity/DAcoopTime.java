package org.blue.dwbackendhive.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class DAcoopTime {
    private long firstPersonId;
    private long secondPersonId;
    private String type;
    private int timeCol;
    private List<Long> movieId;
}