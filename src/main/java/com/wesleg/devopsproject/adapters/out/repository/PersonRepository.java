package com.wesleg.devopsproject.adapters.out.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesleg.devopsproject.adapters.out.repository.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID>{   
}
