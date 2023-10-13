package com.wesleg.devopsproject.adapters.in.controller.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarRequest {
    private String name;
    private String color;
    private Integer year;
    private String model;
}
