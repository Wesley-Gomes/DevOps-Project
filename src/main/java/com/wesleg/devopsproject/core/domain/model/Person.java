package com.wesleg.devopsproject.core.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
   private UUID id;
   private String name;
   private String email;
   private String phone;
   private String username;
   private LocalDateTime createdAt;
}
   