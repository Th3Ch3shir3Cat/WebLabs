package com.Laba2.Laba2.svc;

import com.Laba2.Laba2.core.Car;
import com.Laba2.Laba2.core.Category;
import com.Laba2.Laba2.core.Nadstroika;
import com.Laba2.Laba2.core.TypeTechnika;

import java.util.Date;
import java.util.List;

public interface Laba2Service {

    Car getCarById(Integer id);

    TypeTechnika getTypeTechnikaById(Integer id);

    Category getCategoryById(Integer id);

    void saveCar(Car car);
    void updateCar(Integer id, String imgPath ,String name ,String date, String baza, Nadstroika nadstroika, Category category, TypeTechnika technika);
    void deleteCar(Integer id);

    List<Car> findAllByOrderByNameAsc();

    void saveType(TypeTechnika typeTechnika);
    void updateType(Integer id, String imgPath ,String name);
    void deleteType(Integer id);
    List<TypeTechnika> findAllByOrderByImgPathAsc();

    TypeTechnika technika(Integer id);

    void saveCategory(Category category);
    void updateCategory(Integer id, String imgPath ,String name, TypeTechnika technika);
    void deleteCategory(Integer id);


    List<Category> findByTechnika(TypeTechnika technika);
    List<Car> findByTypeTechnika(TypeTechnika technika);
    List<Nadstroika> findAllByOrderByIdAsc();

}
