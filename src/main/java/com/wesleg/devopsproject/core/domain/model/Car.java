package com.wesleg.devopsproject.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private UUID id;
    private String name;
    private String color;
    private Integer year;
    private String model;
    private LocalDateTime createdAt;
}
