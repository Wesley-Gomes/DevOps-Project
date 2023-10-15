package com.wesleg.devopsproject.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
   private String username;
   private String password;
   private LocalDateTime createdAt;
}
