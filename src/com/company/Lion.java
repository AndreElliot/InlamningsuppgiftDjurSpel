package com.company;

public class Lion extends Animal {

    public Lion (String name, int health, String gender) {
        super(name, health, gender, FoodType.MEAT);

    }

    @Override
    public void printOutValues() {
        if(health > 0)
            System.out.println("Lion | Name: " + name + " | Gender:" + gender.toString().toLowerCase() + " | Health:" + health + "(" + (health - healthLastRound) + ")" +" | Last rounds health: " + healthLastRound);
    }

    @Override
    public FoodType getAnimalFoodType() {
        return FoodType.MEAT;
    }


    @Override
    public String getTheAnimalType() {
        return "lion";
    }
}
