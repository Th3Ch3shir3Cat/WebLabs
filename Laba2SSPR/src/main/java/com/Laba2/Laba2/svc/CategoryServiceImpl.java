package com.Laba2.Laba2.svc;

import com.Laba2.Laba2.core.Category;
import com.Laba2.Laba2.core.TypeTechnika;
import com.Laba2.Laba2.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List findByTechnika(TypeTechnika technika) {
        List categoryz = new ArrayList();
        for(Category category: categoryRepository.findByTechnika(technika)){
            categoryz.add(category.getTechnika());
        }
        return categoryz;
    }
}
