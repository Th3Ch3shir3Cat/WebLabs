package com.Laba2.Laba2.repo;

import com.Laba2.Laba2.core.Nadstroika;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NadstroikaRepository extends JpaRepository<Nadstroika, Integer> {
    List<Nadstroika> findAllByOrderByIdAsc();
}
