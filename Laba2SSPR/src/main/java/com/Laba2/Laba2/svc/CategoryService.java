package com.Laba2.Laba2.svc;

import com.Laba2.Laba2.core.Category;
import com.Laba2.Laba2.core.TypeTechnika;

import java.util.List;
//
public interface CategoryService {
    List findByTechnika(TypeTechnika technika);
}
