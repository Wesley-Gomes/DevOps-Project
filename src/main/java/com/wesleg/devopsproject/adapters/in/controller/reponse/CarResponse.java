package com.wesleg.devopsproject.adapters.in.controller.reponse;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarResponse {
    private UUID id;
    private String name;
    private String color;
    private Integer year;
    private String model;
    private LocalDateTime createdAt;
}
