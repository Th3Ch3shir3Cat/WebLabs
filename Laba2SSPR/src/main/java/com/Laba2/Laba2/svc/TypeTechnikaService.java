package com.Laba2.Laba2.svc;

import com.Laba2.Laba2.core.Category;
import com.Laba2.Laba2.core.TypeTechnika;

import java.util.List;

public interface TypeTechnikaService {

    List<TypeTechnika> technikas();
    TypeTechnika technika(Integer id);

}
