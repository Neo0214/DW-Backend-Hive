package org.blue.dwbackendhive.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Movie {
    private long movieId;
    private String title;
    private int runtime;
    private int comments;
    private String type;
    private float grade;
    private int year;
    private int month;
    private int day;
}