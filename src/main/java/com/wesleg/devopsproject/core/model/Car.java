package com.wesleg.devopsproject.core.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Car {
    private Long id;
    private String name;
    private String color;
    private int year;
}
