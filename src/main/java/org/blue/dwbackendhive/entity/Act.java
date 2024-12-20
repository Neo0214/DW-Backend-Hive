package org.blue.dwbackendhive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Act {
    private long movieId;
    private long personId;
    private String idStarring;
}