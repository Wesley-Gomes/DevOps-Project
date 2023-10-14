package com.wesleg.devopsproject.adapters.out.repository.entity;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "tbl_user")
public class UserEntity {
   @Id
   private String username;

   @NotNull
   @Column(nullable = false)
   private String password;

   @CreationTimestamp
   @Column(updatable = false, nullable = false)
   private LocalDateTime createdAt;
}
