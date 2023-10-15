package com.wesleg.devopsproject.adapters.out.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "person")
public class PersonEntity {
   @Id
   @GeneratedValue(generator = "UUID")
   private UUID id;

   @Column(nullable = false, length = 50)
   private String name;

   @Email
   @Column(nullable = false)
   private String email;

   private String phone;

   @Column(nullable = false)
   private String username;

   @CreationTimestamp
   @Column(updatable = false, nullable = false)
   private LocalDateTime createdAt;
}
