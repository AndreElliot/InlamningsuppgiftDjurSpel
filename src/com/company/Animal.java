package com.company;

import java.util.Random;

enum Gender {
    MALE,
    FEMALE
}

abstract class Animal {

    protected String name;
    protected int health;
    protected int healthLastRound;
    protected Gender gender;
    protected FoodType foodType;
    Random rand = new Random();
    Store store = new Store();

    public Animal(String name, int health, String gender, FoodType foodType) {
        this.name = name;
        this.health = health;
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.foodType = foodType;

    }

    public void decreaseHealth() {
        int n = 10 + rand.nextInt(21);
        healthLastRound = health;
        this.health -= n;
    }

    public void increaseHealthBy10() {
        this.health += 10;
    }

    public int getHealthLastRound() {
        return healthLastRound;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int animalWorthWhenSold(String animalName) {
        return (store.getCostOfAnimalOrFood(animalName) * health / 100);
    }

    public abstract String getTheAnimalType();

    public abstract void printOutValues();

    public abstract FoodType getAnimalFoodType();


}
