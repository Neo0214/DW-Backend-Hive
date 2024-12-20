package org.blue.dwbackendhive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String asin;
    private String format;
    private float grade;
    private float cost;
    private long movieId;
}