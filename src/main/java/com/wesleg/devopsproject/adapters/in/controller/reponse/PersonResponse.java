package com.wesleg.devopsproject.adapters.in.controller.reponse;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonResponse {
   private UUID id;
   private String name;
   private String email;
   private String phone;
   private String username;   
}
