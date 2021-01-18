package com.company;


public class Store {
    enum animalAndFoodShop {
        TIGER(500),
        CHICKEN(100),
        BEEF(50),
        CORN(50);


        int p;

        animalAndFoodShop(int price) {
            p = price;
        }

    }

    public int getCostOfAnimalOrFood(String animal) {
        return animalAndFoodShop.valueOf(animal.toUpperCase()).p;
    }

}

