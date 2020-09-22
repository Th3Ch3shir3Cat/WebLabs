package com.Laba2.Laba2.repo;

import com.Laba2.Laba2.core.Car;
import com.Laba2.Laba2.core.TypeTechnika;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByOrderByNameAsc();
    List<Car> findByTypeTechnika(TypeTechnika technika);
}
