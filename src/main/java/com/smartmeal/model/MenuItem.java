package com.smartmeal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String restaurantName;

    private String dietType;

    private int calories;

    private double price;

    private int proteinGrams;

    @Enumerated(EnumType.STRING)
    private MacroLevel carbsLevel;

    @Enumerated(EnumType.STRING)
    private MacroLevel fatLevel;

    public MenuItem() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProteinGrams() {
        return proteinGrams;
    }

    public void setProteinGrams(int proteinGrams) {
        this.proteinGrams = proteinGrams;
    }

    public MacroLevel getCarbsLevel() {
        return carbsLevel;
    }

    public void setCarbsLevel(MacroLevel carbsLevel) {
        this.carbsLevel = carbsLevel;
    }

    public MacroLevel getFatLevel() {
        return fatLevel;
    }

    public void setFatLevel(MacroLevel fatLevel) {
        this.fatLevel = fatLevel;
    }
}