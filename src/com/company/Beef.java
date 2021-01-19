package com.company;

public class Beef extends Food{

    public Beef(){

        super(FoodType.MEAT);
    }

    @Override
    public FoodType getFoodType(String foodType) {
        if (foodType.equalsIgnoreCase("Beef")) {
            return FoodType.MEAT;
        }
        return null;
    }
}
