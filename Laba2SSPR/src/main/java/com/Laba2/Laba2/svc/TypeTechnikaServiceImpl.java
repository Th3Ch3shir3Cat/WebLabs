package com.Laba2.Laba2.svc;

import com.Laba2.Laba2.core.TypeTechnika;
import com.Laba2.Laba2.repo.TypeTechnikaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TypeTechnikaServiceImpl implements TypeTechnikaService {

    @Autowired
    TypeTechnikaRepository technikaRepository;

    @Override
    public List<TypeTechnika> technikas() {
        return technikaRepository.findAll();
    }

    @Override
    public TypeTechnika technika(Integer id) {
        return technikaRepository.getOne(id);
    }
}
