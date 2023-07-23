package com.example.react.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand;
    private String model;
    private String color;
    private String registerNumber;
    @Column(name = "`year`")
    private int year;
    private int price;

    @ManyToMany(mappedBy = "cars")
    private Set<Owner> owners = new HashSet<>();

    public Car(String brand, String model, String color, String registerNumber, int year, int price, Set<Owner> owners) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        this.owners = owners;
    }
}
