package com.Laba2.Laba2.core;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String imgPath;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_type")
    private TypeTechnika technika;

    public Category(){

    }

    public Category(String name, String imgPath,TypeTechnika technika){
        this.name = name;
        this.imgPath = imgPath;
        this.technika = technika;
    }

    public String getImgPath() {
        return this.imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public TypeTechnika getTechnika() {
        return this.technika;
    }

    public void setTechnika(TypeTechnika technika) {
        this.technika = technika;
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
