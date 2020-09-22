package com.Laba2.Laba2.core;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "type_techika")
public class TypeTechnika {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String imgPath;

    @OneToMany(mappedBy = "typeTechnika", cascade = CascadeType.ALL)
    private Set<Car> cars;

    @OneToMany(mappedBy = "technika", cascade = CascadeType.ALL)
    private Set<Category> categorys;


    public Set<Category> getCategorys() {
        return this.categorys;
    }

    public void setCategorys(Set<Category> categorys) {
        this.categorys = categorys;
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public TypeTechnika(){

    }

    public TypeTechnika(String name_type, String imgPath){
        this.name = name_type;
        this.imgPath = imgPath;
    }


    public String getImgPath() {
        return this.imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
