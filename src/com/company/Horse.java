package com.company;

public class Horse extends Animal {

public Horse (String name, int health, String gender) {
        super(name, health, gender, FoodType.VEGETERIAN);
        }

@Override
public void printOutValues() {
        if(health > 0 && age <= 20)
        System.out.println("Horse | Name: " + name + " | Age:" + age + " out of 20(max age)" + " | Gender:" + gender.toString().toLowerCase() + " | Health:" + health + "(" + (health - healthLastRound) + ")" + " | Last rounds health: " + healthLastRound);

        }

@Override
public FoodType getAnimalFoodType() {
        return FoodType.VEGETERIAN;
        }

@Override
public String getTheAnimalType() {
        return "horse";
        }
}
