package com.wesleg.devopsproject.adapters.out.repository;

import com.wesleg.devopsproject.adapters.out.repository.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, UUID> {
}
