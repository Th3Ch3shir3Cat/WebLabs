package com.Laba2.Laba2.core;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "nadstroika")
public class Nadstroika {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "nadstroika", cascade = CascadeType.ALL)
    private Set<Car> cars;

    public int getId() {
        return this.id;
    }

    public Nadstroika(){

    }

    public Nadstroika(String name, Car...cars){
        this.name = name;
        this.cars = Stream.of(cars).collect(Collectors.toSet());
        this.cars.forEach(x -> x.setNadstroika(this));
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
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
