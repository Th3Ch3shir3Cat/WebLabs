package com.Laba2.Laba2.svc;

import com.Laba2.Laba2.core.Car;
import com.Laba2.Laba2.core.Category;
import com.Laba2.Laba2.core.Nadstroika;
import com.Laba2.Laba2.core.TypeTechnika;
import com.Laba2.Laba2.repo.CarRepository;
import com.Laba2.Laba2.repo.CategoryRepository;
import com.Laba2.Laba2.repo.NadstroikaRepository;
import com.Laba2.Laba2.repo.TypeTechnikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Laba2ServiceImpl implements Laba2Service {

    private CarRepository carRepository;
    private TypeTechnikaRepository typeTechnikaRepository;
    private CategoryRepository categoryRepository;
    private NadstroikaRepository nadstroikaRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository, TypeTechnikaRepository typeTechnikaRepository, CategoryRepository categoryRepository, NadstroikaRepository nadstroikaRepository){
        this.carRepository = carRepository;
        this.typeTechnikaRepository = typeTechnikaRepository;
        this.categoryRepository = categoryRepository;
        this.nadstroikaRepository = nadstroikaRepository;
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.getOne(id);
    }

    @Override
    public TypeTechnika getTypeTechnikaById(Integer id) {
        return typeTechnikaRepository.getOne(id);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.getOne(id);
    }


    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateCar(Integer id, String imgPath ,String name, String date, String baza, Nadstroika nadstroika, Category category, TypeTechnika technika) {
        Car update = carRepository.getOne(id);
        update.setName(name);
        update.setImgPath(imgPath);
        update.setDate(date);
        update.setBaza(baza);
        update.setNadstroika(nadstroika);
        update.setCategory(category);
        update.setTypeTechnika(technika);
        carRepository.save(update);
    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findAllByOrderByNameAsc() {
        return carRepository.findAllByOrderByNameAsc();
    }


    @Override
    public void saveType(TypeTechnika typeTechnika) {
        typeTechnikaRepository.save(typeTechnika);
    }

    @Override
    public void updateType(Integer id, String imgPath, String name) {
        TypeTechnika update = typeTechnikaRepository.getOne(id);
        update.setName(name);
        update.setImgPath(imgPath);
        typeTechnikaRepository.save(update);
    }

    @Override
    public void deleteType(Integer id) {
        typeTechnikaRepository.deleteById(id);
    }

    @Override
    public List<TypeTechnika> findAllByOrderByImgPathAsc() {
        return typeTechnikaRepository.findAllByOrderByImgPathAsc();
    }

    @Override
    public TypeTechnika technika(Integer id) {
        return typeTechnikaRepository.getOne(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Integer id, String imgPath, String name, TypeTechnika technika) {
        Category update = categoryRepository.getOne(id);
        update.setName(name);
        update.setImgPath(imgPath);
        update.setTechnika(technika);
        categoryRepository.save(update);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findByTechnika(TypeTechnika technika) {
        return categoryRepository.findByTechnika(technika);
    }

    @Override
    public List<Car> findByTypeTechnika(TypeTechnika technika) {
        return carRepository.findByTypeTechnika(technika);
    }

    @Override
    public List<Nadstroika> findAllByOrderByIdAsc() {
        return nadstroikaRepository.findAllByOrderByIdAsc();
    }
}
