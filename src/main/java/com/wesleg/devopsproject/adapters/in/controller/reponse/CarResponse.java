package com.wesleg.devopsproject.adapters.in.controller.reponse;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CarResponse {
    private Long id;
    private String name;
    private String color;
    private int year;
}
