package org.blue.dwbackendhive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private long personId;
    private String name;
}