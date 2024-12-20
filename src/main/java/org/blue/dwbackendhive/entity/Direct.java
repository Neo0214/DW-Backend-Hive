package org.blue.dwbackendhive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Direct {
    private long movieId;
    private long personId;
}