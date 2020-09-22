package com.Laba2.Laba2.core;

import javax.persistence.*;

@Entity
@Table(name = "cars")

public class Car {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "image")
    private String imgPath;
    @Column(name = "name")
    private String name;

    @Column(name = "data_born")
    private String date;
    @Column(name = "baza")
    private String baza;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nadstroika")
    private Nadstroika nadstroika;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kategory")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type")
    private TypeTechnika typeTechnika;

    public Car(){

    }

    public Car(String name, String imgPath ,String date, String baza, Nadstroika nadstoika, Category category, TypeTechnika technika){
        this.name = name;
        this.imgPath = imgPath;
        this.date = date;
        this.baza = baza;
        this.nadstroika = nadstoika;
        this.category = category;
        this.typeTechnika = technika;
    }

    public TypeTechnika getTypeTechnika() {
        return this.typeTechnika;
    }

    public void setTypeTechnika(TypeTechnika typeTechnika) {
        this.typeTechnika = typeTechnika;
    }

    public Integer getNadstroikaId(){
        return nadstroika != null ? nadstroika.getId() : 0;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setNadstroika(Nadstroika nadstroika) {
        this.nadstroika = nadstroika;
    }

    public Nadstroika getNadstroika() {
        return this.nadstroika;
    }

    public String getName() {
        return this.name;
    }

    public String getImgPath() {
        return this.imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public String getBaza() {
        return this.baza;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBaza(String baza) {
        this.baza = baza;
    }
}
