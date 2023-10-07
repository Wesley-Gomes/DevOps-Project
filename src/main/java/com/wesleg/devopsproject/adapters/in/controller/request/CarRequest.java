package com.wesleg.devopsproject.adapters.in.controller.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CarRequest {
    private String name;
    private String color;
    private int year;
}
