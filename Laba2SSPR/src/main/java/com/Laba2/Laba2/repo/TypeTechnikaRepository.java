package com.Laba2.Laba2.repo;

import com.Laba2.Laba2.core.TypeTechnika;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeTechnikaRepository extends JpaRepository<TypeTechnika, Integer> {
    List<TypeTechnika> findAllByOrderByImgPathAsc();

}
