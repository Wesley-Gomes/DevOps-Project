package com.wesleg.devopsproject.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesleg.devopsproject.adapters.out.repository.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{   
}
