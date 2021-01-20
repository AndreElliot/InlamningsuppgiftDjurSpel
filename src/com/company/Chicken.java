package com.company;

public class Chicken extends Animal {

    public Chicken(String name, int health, String gender) {
        super(name, health, gender, FoodType.VEGETERIAN);
    }

    @Override
    public void printOutValues() {
        System.out.println("Chicken | Name: " + name + " | Gender:" + gender.toString().toLowerCase() + " | Health:" + health + " | Last rounds health: " + healthLastRound + "(" + (health - healthLastRound) + ")");

    }

    @Override
    public FoodType getAnimalFoodType() {
        return FoodType.VEGETERIAN;
    }

    @Override
    public String getTheAnimalType() {
        return "chicken";
    }
}