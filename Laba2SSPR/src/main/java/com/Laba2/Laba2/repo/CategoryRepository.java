package com.Laba2.Laba2.repo;

import com.Laba2.Laba2.core.Category;
import com.Laba2.Laba2.core.TypeTechnika;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByTechnika(TypeTechnika technika);
}
